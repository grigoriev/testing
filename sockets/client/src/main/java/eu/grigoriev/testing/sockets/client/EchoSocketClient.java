package eu.grigoriev.testing.sockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoSocketClient {
    private Socket clientSocket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public void connect(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        printWriter.println(msg);
        return bufferedReader.readLine();
    }

    public void disconnect() throws IOException {
        bufferedReader.close();
        printWriter.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        EchoSocketClient client = new EchoSocketClient();

        for (int i = 0; i < 1000; i++) {
            long startTime = System.currentTimeMillis();
            client.connect("127.0.0.1", 6666);

            for (int j = 0; j < 1; j++) {
                String response = client.sendMessage("message" + j);
            }

            String responseExit = client.sendMessage("exit");
            client.disconnect();
            long stopTime = System.currentTimeMillis();
            log.info("client" + i + " exec time = " + (stopTime - startTime));
        }

        client.connect("127.0.0.1", 6666);
        String responseExit = client.sendMessage("shutdown");
        client.disconnect();
    }
}
