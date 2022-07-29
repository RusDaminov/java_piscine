//package ex02;

public class UserNotFoundException extends RuntimeException{
   public UserNotFoundException(Integer id) {
       super("User with ID: " + id + " is not found");
   }
}
