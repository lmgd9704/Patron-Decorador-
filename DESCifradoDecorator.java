public class DESCifradoDecorator extends CifradoDecorator {

    public DESCifradoDecorator(Archivo archivo) {
        super(archivo);
    }


    public byte[] leer() {
        System.out.println("🔹 Descifrando con DES...");
        // Simulación de descifrado
        return archivo.leer();
    }


    public void escribir(byte[] datos) {
        System.out.println("🔹 Cifrando con DES...");
        // Simulación de cifrado
        archivo.escribir(datos);
    }
}

