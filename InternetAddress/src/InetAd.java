import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAd {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress google = InetAddress.getByName("www.google.com");
        System.out.println(google.getHostName());

        System.out.println(InetAddress.getLocalHost());

        byte[] mylocal = {(byte)192,(byte)168,(byte)1,(byte)75};
        InetAddress gotByIp = InetAddress.getByAddress(mylocal);
        System.out.println(gotByIp.getCanonicalHostName());

        byte[] checkIp = gotByIp.getAddress();
        if(checkIp.length==4){
            System.out.println("Ipv4");
        }
    }
}
