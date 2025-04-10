package com.giannisf12.service;

import com.giannisf12.exception.UserException;
import com.giannisf12.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers();
    void deleteUser(Long id) throws UserException;
    User updateUser(Long id, User user) throws UserException;


}
