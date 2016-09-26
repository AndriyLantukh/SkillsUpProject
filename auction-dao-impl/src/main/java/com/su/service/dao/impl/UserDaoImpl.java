package com.su.service.dao.impl;

import com.su.service.dao.api.UserDao;
import com.su.domain.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
