import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Start a TCP Connection for web server : ");

        // Make a tcp server socket
        int portNumber = 5000;

        try {
                // So whenever we create server socket in a process, the server socket
                // got associated with that process and port as well. Now no one can
                // create other serverSocket with this port. So we can say in such a way
                // that port is more or less somewhat similar to our processID.

                ServerSocket serverSocket = new ServerSocket(portNumber);
                // This thing should be operates on different thread as it will be blocking call
            while (true) {
                try {
                    System.out.println("Listening server socket at localhost:5000..................");
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client socket connected with server");
                    Thread clientThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(clientSocket.getInputStream()));
                                BufferedWriter out = new BufferedWriter(
                                        new OutputStreamWriter(clientSocket.getOutputStream()));
                                while (true) {
                                    System.out.println("Reading the input received at server side");
                                    String value = in.readLine();
                                    System.out.println("Read : "+value);
                                    System.out.println("Response to Client ");
                                    out.write("Pritam\n");
                                    out.flush();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }

                        }
                    });
                    clientThread.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}