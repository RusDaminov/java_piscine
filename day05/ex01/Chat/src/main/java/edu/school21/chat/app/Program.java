package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessageRepositoryJdbcImpl;

import java.sql.SQLException;
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

        System.out.println("Enter a message ID");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLong()) {
            Long id = scanner.nextLong();
            MessageRepositoryJdbcImpl messageRepositoryJdbc = new MessageRepositoryJdbcImpl(ds);
            Message message = messageRepositoryJdbc.findById(id).orElse(null);
            System.out.println(message);
        } else {
            System.err.println("Please enter number");
            System.exit(-1);
        }




    }
}