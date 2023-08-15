import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpClient {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket(0);

            InetAddress host = InetAddress.getByName("192.168.1.72");

            String message = "hello from client";
            byte[] bytemessage = message.getBytes("US-ASCII");

            DatagramPacket reqPacket = new DatagramPacket(bytemessage, bytemessage.length, host, 14);

            socket.send(reqPacket);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
