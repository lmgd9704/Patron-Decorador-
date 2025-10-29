import java.util.Arrays;

public class ArchivoConcreto implements Archivo {
    private byte[] datos;

    // Constructor: recibe los datos iniciales
    public ArchivoConcreto(byte[] datos) {
        this.datos = Arrays.copyOf(datos, datos.length);
    }

    public byte[] leer() {
        return datos;
    }

    public void escribir(byte[] datos) {
        this.datos = Arrays.copyOf(datos, datos.length);
    }
}
