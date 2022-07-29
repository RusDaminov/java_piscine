//package ex02;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Amanda", 500);
        User user2 = new User("Miranda", 1000);
        User user3 = new User("Boris", 7000);
        User user4 = new User("Ikael", 600);
        User user5 = new User("Sglossu", 1500);
        User user6 = new User("Mtifany", 7200);
        User user7 = new User("Nluya", 500);
        User user8 = new User("Achanel", 1000);
        User user9 = new User("Gmalka", 7000);
        User user10 = new User("Cshanda", 600);
        User user11 = new User("Mhumfrey", 1500);
        User user12 = new User("Tasian", 7200);
        UsersArrayList users = new UsersArrayList();
        try {
            users.addUser(user1);
            users.addUser(user2);
            users.addUser(user3);
            users.addUser(user4);
            users.addUser(user5);
            users.addUser(user6);
            users.addUser(user7);

            System.out.println("Number of users: " + users.numberOfUsers());
            System.out.println("User with id 1: " + users.getUserById(1));
            System.out.println("User in index 5: " + users.getUserByIndex(5));
            System.out.println("Users capacity: " + users.getCapacity());
            users.addUser(user8);
            users.addUser(user9);
            users.addUser(user10);
            users.addUser(user11);
            users.addUser(user12);
            System.out.println("User in id 12: " + users.getUserById(12));
            System.out.println("User in id 13: " + users.getUserById(13));
            System.out.println("Number of users: " + users.numberOfUsers());
            System.out.println("Users capacity: " + users.getCapacity());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
