package com.su.service;

import com.su.domain.User;
import com.su.service.dao.api.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Андрей on 20.09.2016.
 */
@Service
public class UserServiceImpl implements UserServise {

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(String login, String firstName, String lastName) {
        User user = new User(login, firstName, lastName);
        userDao.add(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }
}
