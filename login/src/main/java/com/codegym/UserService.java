package com.codegym;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private static List<User> userList;

    static {
        User user1 = new User("phuoc","123","phuoc@gmail","0961456");
        userList.add(user1);
        User user2 = new User("quang","123","quang@gmail","1245687");
        userList.add(user2);
    }

    public static boolean checkLogin(Login login) {
        boolean check = false;
        for (User user : userList) {
            if (user.getUsername().equals(login.getUsername())) {
                check = true;
            }
        }
        return check;
    }
}
