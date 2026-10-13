package se.systementor.hmsax.lektion14.ovningsuppgifter;

import java.util.List;

public class UserService {
    public String findUser(List<String> users, String name) {
        if (users.contains(name)) {
            return name;
        }
        return null;
    }
}
