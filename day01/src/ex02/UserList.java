//package ex02;

public interface UserList {
    public void addUser(User user);
    public User getUserById(Integer id);
    public User getUserByIndex(Integer index);
    public Integer numberOfUsers();
}
