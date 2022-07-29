//package ex00;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user1 = new User(1, "Amanda", 100);
        User user2 = new User(2, "Miranda", 200);
        User user3 = new User(3, "Boris", -100);
        Transaction transaction1 = new Transaction(UUID.randomUUID(), user1, user2, 100);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(transaction1);
    }
}
