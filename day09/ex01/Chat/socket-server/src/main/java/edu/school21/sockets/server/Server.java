package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.services.UserService;
import edu.school21.sockets.services.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static LinkedList<ServerSomething> serverList = new LinkedList<>();

    public Server(Integer port) {
        try {
            ServerSocket server = new ServerSocket(port);
            try {
                while (true) {
                    Socket socket = server.accept();
                    try {
                        serverList.add(new ServerSomething(socket));
                    } catch (IOException e) {
                        socket.close();
                    }
                }
            } finally {
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
