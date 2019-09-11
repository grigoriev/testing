package eu.grigoriev.testing.sockets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoSocketServer {
    private ServerSocket serverSocket;

    public EchoSocketServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException, InterruptedException {
        boolean shutdown = false;
        while (!shutdown) {
            Socket socket = serverSocket.accept();
            EchoClientHandler echoClientHandler = new EchoClientHandler(socket);
            echoClientHandler.start();
            echoClientHandler.join();
            shutdown = echoClientHandler.isShutdown();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        EchoSocketServer echoSocketServer = new EchoSocketServer(6666);
        echoSocketServer.start();
        echoSocketServer.stop();
    }
}
