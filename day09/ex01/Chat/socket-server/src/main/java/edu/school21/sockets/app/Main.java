package edu.school21.sockets.app;

import edu.school21.sockets.server.Server;
import edu.school21.sockets.server.ServerSomething;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public LinkedList<ServerSomething> serverList = new LinkedList<>();
    public static void main(String[] args) {
        if(args.length == 1 && args[0].matches("--port=\\d+")) {
            int port = Integer.parseInt(args[0].split("=")[1]);
            Server server = new Server(port);
        }
    }
}
