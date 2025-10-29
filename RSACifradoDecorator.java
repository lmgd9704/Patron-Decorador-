import java.util.Base64;

public class RSACifradoDecorator extends CifradoDecorator {

    public RSACifradoDecorator(Archivo archivo) {
        super(archivo);
    }

    public void escribir(byte[] datos) {
        // Simulación de cifrado RSA (reordenamos + codificamos)
        String original = new String(datos);
        String cifrado = Base64.getEncoder().encodeToString(new StringBuilder(original).reverse().toString().getBytes());
        super.escribir(cifrado.getBytes());
    }

    public byte[] leer() {
        // Simulación de descifrado RSA
        byte[] datosCifrados = super.leer();
        String descifrado = new String(Base64.getDecoder().decode(datosCifrados));
        return new StringBuilder(descifrado).reverse().toString().getBytes();
    }
}
