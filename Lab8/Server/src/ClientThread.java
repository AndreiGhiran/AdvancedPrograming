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
        run();
    }

    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                System.out.println(request);
                String response = execute(request);
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(response);
                if (response.equals("Bye!"))
                    break;
                System.out.println(response);
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
        String[] parsedRequest = request.split(" ");
        System.out.println("Executing...");
        switch (parsedRequest[0]) {

            case "register":

                if (parsedRequest.length > 2) {
                    response = "Incalid name! Name must not contain spaces.";
                    break;
                } else if (parsedRequest.length == 1) {
                    System.out.println(parsedRequest.length);
                    for(String i : parsedRequest)
                        System.out.println(i);
                    response = "Please specify a name.";
                    break;
                } else {
                    for (String name : server.usersAndFriends.keySet())
                        if (name.equals(parsedRequest[1])) {
                            response = "Invalid name! Name already used.";
                            break;
                        }
                }

                System.out.println("Success");
                server.usersAndFriends.put(parsedRequest[1], new ArrayList<>());
                response = "User" + parsedRequest[1] + " created.";
                break;

            case "login":
                if (parsedRequest.length < 2) {
                    response = "Please specify a name";
                    break;
                } else {
                    for (String name : server.usersAndFriends.keySet())
                        if (name.equals(parsedRequest[1])) {
                            response = "Welcome!";
                            user = name;
                            break;
                        } else {
                            response = "The specified name does not exist.";
                            break;
                        }
                }

            case "friend":
                if (user.isEmpty()) {
                    response = "Please log in.";
                    break;
                } else if (parsedRequest.length < 2) {
                    response = "Please specify the name of friend/friends to be added.";
                    break;
                } else {
                    for (int i = 1; i < parsedRequest.length; i++)
                        for (String name : server.usersAndFriends.keySet())
                            if (parsedRequest[i].equals(name)) {
                                List<String> friends = server.usersAndFriends.get(user);
                                friends.add(parsedRequest[i]);
                                server.usersAndFriends.put(user, friends);
                                response = response + "Friend " + parsedRequest[i] + " added.\n";
                                break;
                            } else {
                                response = response + "User " + parsedRequest[i] + " does not exist.\n";
                            }
                    break;
                }

            case "send":
                if (user.isEmpty()) {
                    response = "Please log in.";
                    break;
                } else if (parsedRequest.length < 2) {
                    response = "Please specify a message.";
                    break;
                } else {
                    List<String> friends = new ArrayList<>();

                    for (String name : server.usersAndFriends.keySet())
                        if (name.equals(user))
                            friends = server.usersAndFriends.get(name);

                    for (String friend : server.usersAndFriends.get(user)) {

                        HashMap<String, String> friendUser = new HashMap<>();
                        friendUser.put(friend, user);
                        String oldMessage = server.messages.get(friendUser);

                        for (int i = 1; i < parsedRequest.length; i++)
                            oldMessage = oldMessage + " " + parsedRequest[i];
                        oldMessage += "\n";

                        server.messages.put(friendUser, oldMessage);
                        response = response + "Message sent to " + friend + ".\n";
                        break;
                    }
                }

            case "read":
                if (user.isEmpty()) {
                    response = "Please log in.";
                    break;
                } else {
                    List<String> friendList = server.usersAndFriends.get(user);
                    for (String friend : friendList) {
                        HashMap<String, String> friendUser = new HashMap<>();
                        friendUser.put(user, friend);
                        response = response + "Message from " + friend + ": \n" + server.messages.get(friendUser) + "\n";
                    }
                    break;
                }

            case "exit":
                response = "Bye!";
                break;

            default:
                response = "Invalid command.";
        }

        System.out.println("Client " + user + ": " + response);

        return response;
    }
}
