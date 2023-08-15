import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class whois {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket= new Socket("whois.verisign-grs.com", 43);

        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);

        writer.write("example.com\r\n");
        writer.flush();
        

        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line;
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }

        writer.close();
        reader.close();
        socket.close();
        
    }
}
