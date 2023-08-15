import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClien {
    public static void main(String[] args) {
        try{
            MulticastSocket socket = new MulticastSocket(1330);
            InetAddress group = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(group);

            DatagramPacket packet = new DatagramPacket(new byte[1024], 0, 1024, group, 1330);
            socket.receive(packet);

            String mesString = new String(packet.getData(), 0, packet.getData().length);
            System.out.println(mesString);
        }catch(Exception exc){
            
        }
    }
}
