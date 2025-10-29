import java.util.Base64;

public class DESCifradoDecorator extends CifradoDecorator {

    public DESCifradoDecorator(Archivo archivo) {
        super(archivo);
    }

    public void escribir(byte[] datos) {
        // Simulación de cifrado DES
        String cifrado = new StringBuilder(Base64.getEncoder().encodeToString(datos)).reverse().toString();
        super.escribir(cifrado.getBytes());
    }

    public byte[] leer() {
        // Simulación de descifrado DES
        byte[] datosCifrados = super.leer();
        String descifrado = new StringBuilder(new String(datosCifrados)).reverse().toString();
        return Base64.getDecoder().decode(descifrado);
    }
}

