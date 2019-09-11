package eu.grigoriev.testing.sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoClientHandler extends Thread {
    private Socket clientSocket;
    private volatile boolean shutdown;

    public EchoClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if ("exit".equals(line)) {
                    printWriter.println("bye");
                    break;
                }
                if ("shutdown".equals(line)) {
                    printWriter.println("going down...");
                    shutdown = true;
                    break;
                }
                printWriter.println(line);
            }

            bufferedReader.close();
            printWriter.close();
            clientSocket.close();
        } catch (IOException e) {
            log.error("", e);
        }
    }

    public boolean isShutdown() {
        return shutdown;
    }
}
