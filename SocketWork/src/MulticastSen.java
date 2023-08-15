import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSen {
    public static void main(String[] args) {
        try{
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket(1330);
            socket.joinGroup(group);

            while(true){
                String message = "hello from server multi";
                byte[] bytemes = message.getBytes();
                DatagramPacket packet = new DatagramPacket(bytemes, 0, bytemes.length, group, 1330);
                socket.send(packet);
                Thread.sleep(1000);
            }
        }catch(Exception ex){

        }
    }
}
