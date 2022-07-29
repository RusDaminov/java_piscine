package ex04;

public class TransactionsService {
    private UserList userList = new UsersArrayList();

    public void addUser(User user) {

        userList.addUser(user);
    }
    public Integer getUserBalance(User user) {
        return user.getBalance();
    }
    public void transferTransactions(Integer userId1, Integer userId2, Integer amount) {

    }
}
