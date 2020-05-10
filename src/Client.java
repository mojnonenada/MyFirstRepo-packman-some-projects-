
import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket socket = null;
    private static BufferedReader in = null;
    private static PrintWriter out = null;
    private static BufferedReader console = null;
    private static String userMSG, serverMSG;

    public static void main(String[] args) throws IOException {

        socket = new Socket("localhost", 8989);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        console = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            try {
                readMSG();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                sendMSG();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    static void sendMSG() throws IOException {
        while (true) {
            if ((userMSG = console.readLine()) != null) {
                out.println("Client : " + userMSG);
                if (userMSG.equalsIgnoreCase("/end")) break;
            }
        }
    }

    static void readMSG() throws IOException {
        while (true) {
            if ((serverMSG = in.readLine()) != null) {
                System.out.println(serverMSG);
            }
        }
    }
}


