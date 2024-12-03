import java.util.Map;

public class ConversorMonedasApp {

    public static void main(String[] args) {
        InterfazUsuario interfaz = new InterfazUsuario();
        Map<Integer, String[]> monedas = MonedaData.obtenerListadoMonedas();

        interfaz.mostrarBienvenida();
        boolean continuar = true;

        while (continuar) {
            int monedaOrigen = -1, monedaDestino = -1;

            // Selección de moneda de origen con intentos limitados
            monedaOrigen = interfaz.seleccionarMoneda(monedas);
            if (monedaOrigen == -1) break; // Si se agotaron los intentos, se termina el programa

            // Solicitar monto con intentos limitados
            double monto = interfaz.solicitarMonto();
            if (monto == -1) break; // Si se agotaron los intentos, se termina el programa

            // Selección de moneda de destino con intentos limitados
            monedaDestino = interfaz.seleccionarMoneda(monedas);
            if (monedaDestino == -1) break; // Si se agotaron los intentos, se termina el programa

            interfaz.mostrarMensaje("Por favor espere, estamos procesando la conversión...");
            // Obtener la tasa de cambio usando la API
            double tasaCambio = HttpClientMonedas.obtenerTasaDeCambio(monedas.get(monedaOrigen)[0], monedas.get(monedaDestino)[0]);
            if (tasaCambio == -1) {
                interfaz.mostrarMensaje("No se pudo obtener la tasa de cambio. Inténtalo nuevamente.");
                continue;
            }

            // Realizar la conversión
            double resultado = monto * tasaCambio;
            interfaz.mostrarMensaje(String.format(
                    "Resultado de la conversión:\n\n%,.2f %s equivale a %,.2f %s",
                    monto, monedas.get(monedaOrigen)[0], resultado, monedas.get(monedaDestino)[0]
            ));


            continuar = interfaz.deseaContinuar();
        }

        interfaz.mostrarMensaje("\nGracias por usar el conversor de monedas. ¡Hasta pronto!");
    }
}
