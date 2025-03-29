import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.SocketException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String ADDR = "127.0.0.1";
    private static final int PORT = 5000;
    private Client mClient = null;

    public static void main(String[] args) {
        Client client = new Client(ADDR, PORT);
        client.connectToSocket();
    }
}

class Client {
    private Socket mSocket = null;
    private String addr = null;
    private int port = 0;

    public Client(String addr, int port) {
        this.addr = addr;
        this.port = port;
    }


    public void connectToSocket() {
        try {
            System.out.println("Connecting with socket");
            mSocket = new Socket(addr,port);
            System.out.println("Socket : "+mSocket.toString());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(mSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(mSocket.getOutputStream()));
            out.write("Rahul\n");
            out.flush();

            while (true) {
                String value = in.readLine();
                System.out.println("Read in client side : "+value);
            }

        } catch (SocketException e) {
            System.out.println("Socket closed because of server got disconnected 2");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Socket closed because of server got disconnected 1");
        }
    }
}