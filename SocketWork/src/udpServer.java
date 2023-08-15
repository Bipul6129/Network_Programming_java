import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udpServer {
    public static void main(String[] args) {
        try{
            DatagramSocket servSocket = new DatagramSocket(14);
            while(true){
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                servSocket.receive(request);

                String dataReceive = new String(request.getData(),0,request.getLength(),"US-ASCII");
                System.out.println(dataReceive);

            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
