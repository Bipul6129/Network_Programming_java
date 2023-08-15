import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class cOOkie {
    public static void main(String[] args) {
        CookieManager cManager = new CookieManager();
        CookieHandler.setDefault(cManager);

        HttpCookie cook = new HttpCookie("cookieName","vale");

        URI uri = URI.create("http://example.com");
        CookieStore store = cManager.getCookieStore();
        store.add(uri,cook);

        List<HttpCookie> cookies = cManager.getCookieStore().get(uri);
        for(HttpCookie cookie : cookies){
            System.out.println(cookie.getValue());
        }
    }
}
