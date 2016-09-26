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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(String login, String firstName, String lastName) {
        if (getUsers().stream().anyMatch(user -> user.getLogin().equals(login))) {
            System.out.println("User with login " + login + " already present. Please change login and try again.");
            return null;
        }
        User user = new User(login, firstName, lastName);
        userDao.add(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }

    @Override
    public User getUserByLogin(String login) {
        if (getUsers().stream().noneMatch(user -> user.getLogin().equals(login))) {
            return null;
        }
        return getUsers().stream().filter(user -> user.getLogin().equals(login)).findFirst().get();
    }

}
