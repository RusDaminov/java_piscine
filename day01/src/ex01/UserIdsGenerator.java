//package ex01;


import java.util.UUID;

public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private Integer identifier = 0;
    private UserIdsGenerator(){}
    public static Integer generateId() {
        return ++instance.identifier;
    }

    public static UserIdsGenerator getInstance() {
        if(instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }
}
