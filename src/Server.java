
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static BufferedReader in = null;
    private static PrintWriter out = null;
    private static ServerSocket serverSocket = null;
    private static Socket socket = null;
    private static BufferedReader console = null;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            System.out.print("Сервер запущен . . .");
            socket = serverSocket.accept();
            System.out.println("Клиент присоединился . . . ");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            while (true) {
                String txt = null;
                try {
                    txt = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (txt != null) {
                    try {
                        sendMessage(txt);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            try {
                writeToConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        writeToConsole();
    }

    static void sendMessage(String msg) throws IOException {
        if (msg.equalsIgnoreCase("/end ")) close();
        out.println("Server : " + msg);
        System.out.println(msg);
    }

    static void close() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

    static void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt);
        }
    }
}