import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ReadTime{
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("time.nist.gov",13);
        socket.setSoTimeout(1500);
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream buffered = new BufferedInputStream(inputStream);

        InputStreamReader reader = new InputStreamReader(buffered);
        BufferedReader buff = new BufferedReader(reader);
        String line;
        while((line=buff.readLine())!=null){
            System.out.println(line);
        }
        buff.close();
        socket.close();
    }
}