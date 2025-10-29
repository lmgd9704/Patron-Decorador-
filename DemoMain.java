import java.util.Scanner;

public class DemoMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Encabezado Principal
        System.out.println("\033[38;5;208m" + "╔══════════════════════════════════════════════════╗" + "\033[0m");
        System.out.println("\033[38;5;208m" + "║ \uD83D\uDDE1\uFE0F *** SISTEMA DE CIFRADO DE ARCHIVOS *** \uD83D\uDDE1\uFE0F ║" + "\033[0m");
        System.out.println("\033[38;5;208m" + "╚══════════════════════════════════════════════════╝" + "\033[0m");

        // Entrada del contenido del archivo
        System.out.print("\n\033[38;5;117m" + "\uD83D\uDCC4 Ingrese el contenido del archivo: " + "\033[0m");
        String mensaje = sc.nextLine();

        Archivo archivo = new ArchivoConcreto(mensaje.getBytes());

        // Menú de opciones
        System.out.println("\n\033[38;5;46m" + "\uD83D\uDD3A Opciones disponibles:" + "\033[0m");
        System.out.println("\033[38;5;46m" + "  [1] \uD83D\uDDDC\uFE0F Compresión" + "\033[0m");
        System.out.println("\033[38;5;46m" + "  [2] \uD83D\uDD12 Cifrado AES" + "\033[0m");
        System.out.println("\033[38;5;46m" + "  [3] \uD83D\uDD13 Cifrado DES" + "\033[0m");
        System.out.println("\033[38;5;46m" + "  [4] \uD83D\uDD0E Cifrado RSA" + "\033[0m");
        System.out.println("\033[38;5;46m" + "  [5] \u270D\uFE0F Firma Digital" + "\033[0m");
        System.out.print("\033[38;5;117m" + "\u27A1\uFE0F Seleccione (ej: 1,2,5): " + "\033[0m");
        String[] seleccion = sc.nextLine().split(",");

        // Aplicando opciones
        System.out.println("\n\033[38;5;39m" + "\u2728 Aplicando:" + "\033[0m");
        for (String opcion : seleccion) {
            switch (opcion.trim()) {
                case "1": archivo = new CompresionDecorator(archivo); System.out.println("\033[38;5;47m" + "  \u2714\uFE0F Compresión" + "\033[0m"); break;
                case "2": archivo = new AESCifradoDecorator(archivo); System.out.println("\033[38;5;47m" + "  \u2714\uFE0F Cifrado AES" + "\033[0m"); break;
                case "3": archivo = new DESCifradoDecorator(archivo); System.out.println("\033[38;5;47m" + "  \u2714\uFE0F Cifrado DES" + "\033[0m"); break;
                case "4": archivo = new RSACifradoDecorator(archivo); System.out.println("\033[38;5;47m" + "  \u2714\uFE0F Cifrado RSA" + "\033[0m"); break;
                case "5": archivo = new FirmaDigitalDecorator(archivo); System.out.println("\033[38;5;47m" + "  \u2714\uFE0F Firma Digital" + "\033[0m"); break;
                default: System.out.println("\033[38;5;196m" + "  \u26A0\uFE0F Opción inválida: " + opcion + "\033[0m");
            }
        }

        archivo.escribir(archivo.leer());

        // Resultado final
        System.out.println("\n\033[38;5;208m" + "══════════════════════════════════════════════════" + "\033[0m");
        System.out.println("\033[38;5;50m" + "\uD83D\uDCA1 Resultado:" + "\033[0m");
        System.out.println("\033[38;5;82m" + new String(archivo.leer()) + "\033[0m");
        System.out.println("\033[38;5;208m" + "══════════════════════════════════════════════════" + "\033[0m\n");

        sc.close();
    }
}
