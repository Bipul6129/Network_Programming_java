import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serversite {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(13);
            while(true){
            Socket socket = serverSocket.accept();
            Thread task = new HelloThread(socket);
            task.start();
            
            }

        }catch(Exception ex){

        }
    }

    public static class HelloThread extends Thread{
        private Socket socket;

        HelloThread(Socket socket){
            this.socket=socket;
        }

        @Override
        public void run(){
            OutputStream outputStream;
            try {
   
                outputStream = socket.getOutputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);
                BufferedWriter writer = new BufferedWriter(outputStreamWriter);

                writer.write("Hello from server");
                writer.close();
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }
}
