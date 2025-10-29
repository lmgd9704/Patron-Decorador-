import java.util.Base64;

public class AESCifradoDecorator extends CifradoDecorator {

    public AESCifradoDecorator(Archivo archivo) {
        super(archivo);
    }

    public void escribir(byte[] datos) {
        // Simulación de cifrado AES (aquí solo codificamos Base64)
        String cifrado = Base64.getEncoder().encodeToString(datos);
        super.escribir(cifrado.getBytes());
    }

    public byte[] leer() {
        // Simulación de descifrado AES
        byte[] datosCifrados = super.leer();
        return Base64.getDecoder().decode(datosCifrados);
    }
}
