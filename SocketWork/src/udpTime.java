import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class udpTime {
    public static void main(String[] args){
        try {
            DatagramSocket socket = new DatagramSocket(0);
            socket.setSoTimeout(15000);

            InetAddress host = InetAddress.getByName("time.windows.com");
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, 13);
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);

            socket.send(request);
            socket.receive(response);

            String result = new String(response.getData(), 0, response.getLength(), "US-ASCII");
            System.out.println(result);
        } catch (SocketTimeoutException e) {
            System.out.println("Socket timeout: No response from the server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
