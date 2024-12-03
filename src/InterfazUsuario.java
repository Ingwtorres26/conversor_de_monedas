import java.util.Map;
import java.util.Scanner;

public class InterfazUsuario {

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarBienvenida() {
        System.out.println("*************************************");
        System.out.println("Bienvenido/a al conversor de monedas");
        System.out.println("*************************************\n");
    }

    public int seleccionarMoneda(Map<Integer, String[]> monedas) {
        int intentos = 0;
        while (intentos < 2) {
            System.out.println("Cargando lista de monedas, por favor espere...");
            try {
                Thread.sleep(3000); // Pausa de 3 segundos (3000 ms)
            } catch (InterruptedException e) {
                System.out.println("Hubo un problema durante la pausa.");
                Thread.currentThread().interrupt(); // Restablece el estado de interrupción
            }

            System.out.printf("%-4s %-10s %-20s %-30s\n", "No.", "Code", "Currency Name", "Country");
            monedas.forEach((key, value) ->
                    System.out.printf("%-4d %-10s %-20s %-30s\n", key, value[0], value[1], value[2])
            );
            System.out.println("\nPor favor ingrese el número correspondiente al tipo de moneda que desea convertir:");

            try {
                int seleccion = Integer.parseInt(scanner.nextLine());
                if (monedas.containsKey(seleccion)) {
                    return seleccion;
                } else {
                    System.out.println("La opción ingresada no existe. Inténtalo de nuevo.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.\n");
            }
            intentos++;
            if (intentos < 2) {
                System.out.println("Intenta nuevamente. Te quedan " + (2 - intentos) + " intentos.");
            }
        }
        System.out.println("Se agotaron los intentos. El programa finalizará.");
        System.exit(0); // Finaliza el programa inmediatamente después de 2 intentos fallidos
        return -1; // Esta línea no será alcanzada, pero es necesaria para la lógica
    }

    public double solicitarMonto() {
        int intentos = 0;
        while (intentos < 2) {
            System.out.print("Por favor ingrese el monto que desea convertir: ");
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
            intentos++;
            if (intentos < 2) {
                System.out.println("Intenta nuevamente. Te quedan " + (2 - intentos) + " intentos.");
            }
        }
        System.out.println("Se agotaron los intentos. El programa finalizará.");
        System.exit(0); // Finaliza el programa inmediatamente después de 2 intentos fallidos
        return -1; // Esta línea no será alcanzada, pero es necesaria para la lógica
    }

    public boolean deseaContinuar() {
        System.out.print("¿Desea realizar otra conversión? (1: Sí, 2: No): ");
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            return opcion == 1;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Finalizando el programa.");
            return false;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
