package com.su.dao.impl;

import com.su.dao.api.UserDao;
import com.su.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void add(User entity) {
        users.add(entity);
    }

    @Override
    public void remove(User entity) {
        users.remove(entity);
    }


}
