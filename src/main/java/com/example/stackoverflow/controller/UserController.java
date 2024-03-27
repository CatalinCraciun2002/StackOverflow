package com.example.stackoverflow.controller;

import com.example.stackoverflow.entity.User;
import com.example.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> retrieveAllUsers() {
        return this.userService.retrieveUsers();
    }

    @PostMapping("/registerUser")
    @ResponseBody
    public User insertUser(@RequestBody User user) {
        return this.userService.insertUser(user);
    }

    @PutMapping("/updateUser")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long id) {
        return this.userService.deleteById(id);
    }
}
