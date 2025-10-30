public class RSACifradoDecorator extends CifradoDecorator {

    public RSACifradoDecorator(Archivo archivo) {
        super(archivo);
    }

    public byte[] leer() {
        System.out.println("🔹 Descifrando con RSA...");
        // Simulación de descifrado
        return archivo.leer();
    }

    public void escribir(byte[] datos) {
        System.out.println("🔹 Cifrando con RSA...");
        // Simulación de cifrado
        archivo.escribir(datos);
    }
}

