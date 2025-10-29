import java.util.zip.*;
import java.io.*;

public class CompresionDecorator extends CifradoDecorator {

    public CompresionDecorator(Archivo archivo) {
        super(archivo);
    }

  
    public void escribir(byte[] datos) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             GZIPOutputStream gzip = new GZIPOutputStream(bos)) {
            gzip.write(datos);
            gzip.close();
            super.escribir(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] leer() {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(super.leer());
             GZIPInputStream gzip = new GZIPInputStream(bis);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzip.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
