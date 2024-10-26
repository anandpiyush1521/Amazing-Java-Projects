package com.user.service.Impl;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //Fake user List
    List<User> list = List.of(
            new User(1311L, "Rahul Singhania", "8340774968"),
            new User(1312L, "Piyush Anand", "9430446059"),
            new User(1313L, "Rahul Singh", "8340778974"),
            new User(1314L, "Nisha Anand", "912513698")
    );

    @Override
    public User getUser(Long userId) {
        return this.list.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
    }
}
