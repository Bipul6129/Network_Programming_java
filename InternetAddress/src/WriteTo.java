import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WriteTo {
    public static void main(String[] args) throws IOException {
        URL u = new URL("http://www.example.com");
        URLConnection uc = u.openConnection();
        uc.setDoOutput(true);

        OutputStream raw = uc.getOutputStream();
        BufferedOutputStream buffered = new BufferedOutputStream(raw);
        OutputStreamWriter out = new OutputStreamWriter(buffered);
    
        out.write("name=hello&world=earth");
        out.flush();
        out.close();

    }
}
