package com.giannisf12.controller;

import com.giannisf12.exception.UserException;
import com.giannisf12.model.User;
import com.giannisf12.repository.UserRepository;
import com.giannisf12.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {

        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity< List<User> > getUsers() {

        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) throws Exception {

        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) throws Exception {

        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) throws Exception {

        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.ACCEPTED);
    }
}
