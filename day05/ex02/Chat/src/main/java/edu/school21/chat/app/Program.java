package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.MessagesRepository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) throws SQLException {
        final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASSWORD = "postgres";
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(JDBC_URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);

        MessagesRepository messageRepository = new MessagesRepositoryJdbcImpl(ds);


        System.out.println("Enter a message ID");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLong()) {
            Long id = scanner.nextLong();

            Optional<Message> messageOptional = messageRepository.findById(id);
            messageOptional.ifPresent(System.out::println);
        } else {
            System.err.println("Please enter number");
            System.exit(-1);
        }

        User creator = new User(5L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(5L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());

        messageRepository.save(message);

        System.out.println(message.getId());
    }
}