//package ex00;

public class User {
    private Integer id;
    private String name;
    private Integer balance;
    User(Integer id, String name, Integer balance) {
        if(balance < 0) {
            this.balance = 0;
            System.out.println("You can't create user with negative balance");
        } else
            this.balance = balance;
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Integer balance) {
        if(balance < 0)
            System.out.println("You can't set negative balance");
        else
            this.balance = balance;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
