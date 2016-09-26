package com.su.service;

import com.su.domain.User;

import java.util.List;

public interface UserService {

    User createUser(String login, String firstName, String lastName);

    List<User> getUsers();

    User getUserByLogin(String login);

}
