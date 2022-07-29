package ex04;

public class UsersArrayList implements UserList {
    private User[] users;
    private Integer size;
    private Integer capacity;
    public UsersArrayList() {
        users = new User[10];
        size = 0;
        capacity = 10;
    }
    @Override
    public void addUser(User user) {
        if (size == capacity) {
            capacity *= 2;
            User[] tmp = new User[capacity];
            for (int i = 0; i < size; i++) {
                tmp[i] = users[i];
            }
            tmp[size] = user;
            size++;
            users = tmp;
        } else {
            this.users[this.size] = user;
            size++;
        }

    }

    @Override
    public User getUserById(Integer id) {
        for(int i = 0; i < size; i++) {
            if(id == users[i].getId())
                return users[i];
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public User getUserByIndex(Integer index) {
        if(index < size)
            return users[index];
        return null;
    }

    @Override
    public Integer numberOfUsers() {
        return size;
    }
}
