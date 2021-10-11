package com.panaskin.cacheapp.dao;

import com.panaskin.cacheapp.entity.User;

import java.util.UUID;

public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(String id, User user);
    User getUser(UUID id);
    void deleteById(String id);
}
