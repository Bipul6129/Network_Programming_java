import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInter {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> myEnumeration = NetworkInterface.getNetworkInterfaces();

        while(myEnumeration.hasMoreElements()){    
            NetworkInterface in = myEnumeration.nextElement();
            System.out.print(in.getName());
            Enumeration <InetAddress> addres = in.getInetAddresses();
            while(addres.hasMoreElements()){
                InetAddress en = addres.nextElement();
                System.out.print(en.getHostAddress());
            }
            System.out.println();
        }

    }
}
