public abstract class CifradoDecorator implements Archivo {
    protected Archivo archivo; // Referencia al componente base

    public CifradoDecorator(Archivo archivo) {
        this.archivo = archivo;
    }


    public byte[] leer() {
        return archivo.leer();
    }


    public void escribir(byte[] datos) {
        archivo.escribir(datos);
    }
}

