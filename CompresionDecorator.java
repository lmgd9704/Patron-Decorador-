public class CompresionDecorator extends CifradoDecorator {

    public CompresionDecorator(Archivo archivo) {
        super(archivo);
    }

    @Override
    public byte[] leer() {
        System.out.println("🔹 Descomprimiendo archivo...");
        byte[] datos = archivo.leer();
        // Simulación: simplemente devuelve los mismos datos
        return datos;
    }

    @Override
    public void escribir(byte[] datos) {
        System.out.println("🔹 Comprimiendo archivo...");
        // Simulación: podrías reducir artificialmente el tamaño o dejar igual
        archivo.escribir(datos);
    }
}

