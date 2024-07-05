package com.example.demo.Services;

import com.example.demo.Entity.Payloads.UpdateUserPayload;
import com.example.demo.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUser(int id);
    Iterable<User> findUsers(String name);
    User saveUser(String name,String email,int age);
    void updateUser(int id, UpdateUserPayload user);
    void deleteUser(int id);
}
