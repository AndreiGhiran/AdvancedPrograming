
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocialNetworkClient {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    
    public static void main(String[] args) throws IOException {
        SocialNetworkClient client = new SocialNetworkClient();
        
        Socket socket = new Socket(SERVER_ADDRESS, PORT);
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
            	client.sendRequestToServer(request,socket);
                break;
            } else {
                client.sendRequestToServer(request,socket);
            }
        }
    }
   
	
    private void sendRequestToServer(String request, Socket socket) {
		// TODO Auto-generated method stub
    	try {
    		
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		//Trimit request la server
			out.println(request);
			
		//Astept un raspuns(obtional)
			String response = in.readLine();
			System.out.println(response);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
			e.printStackTrace();
		}
		
	}

	private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}