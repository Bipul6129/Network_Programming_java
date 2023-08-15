import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class Clientsite {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("192.168.1.75", 13);
        // SocketFactory factory = SSLSocketFactory.getDefault();
        // Socket socket = factory.createSocket("192.168.1.75", 13);
    

        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line;
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
        socket.close();
        
    }
}
