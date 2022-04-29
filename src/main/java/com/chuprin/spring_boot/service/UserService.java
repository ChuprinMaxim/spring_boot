package com.chuprin.spring_boot.service;

import com.chuprin.spring_boot.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(long id);

    public void deleteUser(long id);
}
