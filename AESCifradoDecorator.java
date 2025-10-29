public class AESCifradoDecorator extends CifradoDecorator {

    public AESCifradoDecorator(Archivo archivo) {
        super(archivo);
    }


    public byte[] leer() {
        System.out.println("🔹 Descifrando con AES...");
        // Simulación de descifrado (sin lógica real)
        return archivo.leer();
    }


    public void escribir(byte[] datos) {
        System.out.println("🔹 Cifrando con AES...");
        // Simulación de cifrado
        archivo.escribir(datos);
    }
}
