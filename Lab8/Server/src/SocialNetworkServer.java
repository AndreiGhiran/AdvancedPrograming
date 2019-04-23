import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.List;

public class SocialNetworkServer {
    private static final int PORT = 8100;
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

    }

    private void waitForClients(){

    }

    public void stop() throws IOException{
        this.running = false;
        serverSocket.close();
    }
}
