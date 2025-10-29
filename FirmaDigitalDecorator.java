import java.security.MessageDigest;

public class FirmaDigitalDecorator extends CifradoDecorator {

    public FirmaDigitalDecorator(Archivo archivo) {
        super(archivo);
    }

    @Override
    public void escribir(byte[] datos) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] firma = md.digest(datos);

            // Adjuntamos la firma al final
            byte[] combinado = new byte[datos.length + firma.length];
            System.arraycopy(datos, 0, combinado, 0, datos.length);
            System.arraycopy(firma, 0, combinado, datos.length, firma.length);
            super.escribir(combinado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] leer() {
        byte[] datosFirmados = super.leer();

        // Eliminamos los últimos 32 bytes (firma SHA-256)
        if (datosFirmados.length > 32) {
            byte[] datosOriginales = new byte[datosFirmados.length - 32];
            System.arraycopy(datosFirmados, 0, datosOriginales, 0, datosOriginales.length);
            return datosOriginales;
        }
        return datosFirmados;
    }
}
