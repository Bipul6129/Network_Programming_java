import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class OpenStrea {
    public static void main(String[] args) throws IOException {
        URL exampleUrl = new URL("http://example.com");
        InputStream in = exampleUrl.openStream();
        in = new BufferedInputStream(in);

        Reader reader = new InputStreamReader(in);
        // reader = new BufferedReader(reader);
        InputStreamReader reader2 = new InputStreamReader(in);
    
        int line;
        StringBuilder page = new StringBuilder();
        // while((line=reader.read()) != -1){
        //     page.append((char)line);
            
        // }

        while((line=reader2.read())!=-1){
            page.append((char)line);
        }

        System.out.println(page);
        FileWriter writer = new FileWriter("output.txt");
        BufferedWriter wBufferedWriter = new BufferedWriter(writer);
        wBufferedWriter.write("hello");
        wBufferedWriter.close();

        URLConnection connection = exampleUrl.openConnection();
        String header;
        for(int i=0;;i++){
            header=connection.getHeaderField(i);
            if(header==null){
                break;
            }else{
                System.out.println(connection.getHeaderFieldKey(i)+":"+header);
            }
        }
        


    }
}
