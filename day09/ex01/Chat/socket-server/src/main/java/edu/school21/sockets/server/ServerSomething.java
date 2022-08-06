package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.Socket;

public class ServerSomething extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    UsersRepository usersRepository;
    UserService userService;


    public ServerSomething(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello from server!");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
        usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
        userService = context.getBean(UserService.class);
        begin();
        out.println("Start messaging");
        start();
    }
    @Override
    public void run() {
        String msg;
        while (true) {
            try {
                msg = in.readLine();
                if("Exit".equals(msg)) {
                    break;
                }
                addToList(msg);
                for (ServerSomething vr : Server.serverList) {
                    vr.send(msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void send(String msg) {
        out.println(msg);
    }

    private void begin(){
        try {
            String commandName= in.readLine();
            System.out.println(commandName);
            while(true) {
                if ("signUp".equalsIgnoreCase(commandName)) {
                    if(signUp()) {
                        break;
                    }
                } else if ("signIn".equalsIgnoreCase(commandName)) {
                    if(signIn()) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean signUp() throws IOException {
        out.println("Enter username:");
        String userName = in.readLine();
        out.println("Enter password:");
        String password = in.readLine();
        User user = new User(userName, password);
        if(!userService.signUp(user)){
            out.println("User with this name present in the table please try again");
            return false;
        }
        return true;
    }
    private boolean signIn() throws IOException {
        out.println("Enter username:");
        String userName = in.readLine();
        out.println("Enter password:");
        String password = in.readLine();
        User user = new User(userName, password);
        if(!userService.signIn(user)){
            out.println("User with this name not found or password is wrong, please try again");
            return false;
        }
        return true;
    }
}
