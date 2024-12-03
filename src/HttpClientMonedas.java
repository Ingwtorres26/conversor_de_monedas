import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class HttpClientMonedas {

    // Método para obtener la tasa de cambio entre dos monedas
    public static double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) {
        String apiKey = "7c7e0b91e31b84a4d5f0d58c"; // API Key proporcionada
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", apiKey, monedaOrigen, monedaDestino);

        // Crear cliente HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Crear solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Realizar la solicitud y recibir la respuesta
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado
            int statusCode = response.statusCode();
            if (statusCode == 200) {
                // Procesar la respuesta JSON usando Gson
                String responseBody = response.body();
                JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();

                // Extraer la tasa de cambio correctamente desde "conversion_rate"
                double tasaCambio = jsonResponse.get("conversion_rate").getAsDouble();
                return tasaCambio;
            } else {
                System.out.println("Error al obtener los datos de la API. Código de estado: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return -1;  // En caso de error o respuesta inválida
    }

    // Método para realizar la conversión de moneda
    public static double convertirMoneda(double monto, double tasaCambio) {
        return monto * tasaCambio;
    }
}
