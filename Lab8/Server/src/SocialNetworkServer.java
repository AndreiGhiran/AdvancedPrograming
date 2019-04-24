import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class SocialNetworkServer {
    private static final int PORT = 8100;
    private static final String serverAddress = "127.0.0.1";
    private ServerSocket serverSocket;
    private boolean running = false;
    public HashMap<String, List<String>> usersAndFriends = new HashMap<>();
    public HashMap<HashMap<String, String>, String > messages = new HashMap<>();

    public static void main(String[] args) {
        SocialNetworkServer server = new SocialNetworkServer();
        server.init();
        server.waitForClients();
    }

    private void init(){
        try {
            serverSocket = new ServerSocket(PORT);
            running = true;
            System.out.println("Server started.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitForClients(){
        while (running){
            try {

                Socket socket = serverSocket.accept();

                new ClientThread(this, socket).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() throws IOException{
        this.running = false;
        serverSocket.close();
    }
}
