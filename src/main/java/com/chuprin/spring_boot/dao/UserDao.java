package com.chuprin.spring_boot.dao;

import com.chuprin.spring_boot.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(long id);

    public void deleteUser(long id);
}
