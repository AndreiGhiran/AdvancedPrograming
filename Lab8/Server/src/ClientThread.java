import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientThread extends Thread {
    private Socket socket = null;
    private final SocialNetworkServer server;
    private String user = new String();

    public ClientThread(SocialNetworkServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
        System.out.println("A new client has connected.");
//        run();
    }

    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                System.out.println("Primit request:");
                System.out.println(request);
                String response = execute(request);
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(response);
                if (response.equals("Bye!"))
                    break;
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String execute(String request) {
        String response = new String();

        // Split the request
        String[] parsedRequest = request.split(" ");

        // Remove whitespaces
        for (String i : parsedRequest)
            i = i.replaceAll("\\s+", "");

        System.out.println("Executing...");
        switch (parsedRequest[0]) {

            case "register":
                boolean found = false;

                if (parsedRequest.length > 2) {
                    response = "Incalid name! Name must not contain spaces.\nEOF";
                    break;
                } else if (parsedRequest.length == 1) {
                    System.out.println(parsedRequest.length);
                    for (String i : parsedRequest)
                        System.out.println(i);
                    response = "Please specify a name.\nEOF";
                    break;
                } else {
                    for (String name : server.usersAndFriends.keySet())
                        if (name.equals(parsedRequest[1])) {
                            response = "Invalid name! Name already used.\nEOF";
                            found = true;
                        }
                }
                if (found == false) {
                    System.out.println("Success");
                    server.usersAndFriends.put(parsedRequest[1], new ArrayList<>());
                    response = "User " + parsedRequest[1] + " created.\nEOF";
                }
                break;

            case "login":
                if (parsedRequest.length < 2) {
                    response = "Please specify a name\nEOF";
                    break;
                } else {
                    response = "The specified name does not exist.\nEOF";
                    for (String name : server.usersAndFriends.keySet())
                        if (name.equals(parsedRequest[1])) {
                            response = "Welcome!\nEOF";
                            user = name;
                            break;
                        }
                    break;
                }

            case "friend":
                found = false;

                if (user.isEmpty()) {
                    response = "Please log in.\nEOF";
                    break;
                } else if (parsedRequest.length < 2) {
                    response = "Please specify the name of friend/friends to be added.\nEOF";
                    break;
                } else {
                    for (int i = 1; i < parsedRequest.length; i++) {
                        for (String name : server.usersAndFriends.keySet())
                            if (parsedRequest[i].equals(name)) {
                                List<String> friends = server.usersAndFriends.get(user);
                                friends.add(parsedRequest[i]);
                                server.usersAndFriends.put(user, friends);
                                response = response + "Friend " + parsedRequest[i] + " added.\nEOF";
                                found = true;
                                break;
                            }
                        if (found == false)
                            response = response + "User " + parsedRequest[i] + " does not exist.\nEOF";
                    }
                }

                break;

            case "send":
                if (user.isEmpty()) {
                    response = "Please log in.\nEOF";
                    break;
                } else if (parsedRequest.length < 2) {
                    response = "Please specify a message.\nEOF";
                    break;
                } else {
                    List<String> friends =  server.usersAndFriends.get(user);

                    for (String friend : friends) {

                        HashMap<String, String> friendUser = new HashMap<>();
                        friendUser.put(friend, user);
                        String oldMessage = server.messages.get(friendUser);

                        for (int i = 1; i < parsedRequest.length; i++)
                            oldMessage = oldMessage + " " + parsedRequest[i];
                        oldMessage += "\n";

                        server.messages.put(friendUser, oldMessage);
                        response = response + "Message sent to " + friend + ".\nEOF";
                        break;
                    }
                    break;
                }

            case "read":
                if (user.isEmpty()) {
                    response = "Please log in.\nEOF";
                    break;
                } else {
                    List<String> friendList = server.usersAndFriends.get(user);
                    for (String friend : friendList) {
                        HashMap<String, String> friendUser = new HashMap<>();
                        friendUser.put(user, friend);
                        response = response + "Message from " + friend + ": \n" + server.messages.get(friendUser);
                    }
                    System.out.println("response after read command: " + response);
                    response = response + "\nEOF";
                    break;
                }

            case "exit":
                response = "Bye!\nEOF";
                break;

            default:
                response = "Invalid command.\nEOF";
        }

        System.out.println("He is " + user);

        System.out.println("Client " + user + ": " + response);

       // response = response + "EOF";

        return response;
    }
}
