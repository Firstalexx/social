package ru.cavd.social.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cavd.social.models.User;
import ru.cavd.social.services.UserService;

import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    public UserService userService;
//    @RequestBody Customer customer
//    @PostMapping(path="/add")
//    public @ResponseBody User addNewUser (@RequestParam String name
//            , @RequestParam String email
//            , @RequestParam String password) {
//        return userService.saveUser(name, email, password);
//    }

    @PostMapping(path="/add")
    public @ResponseBody User addNewUser (@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public @ResponseBody Optional<User> getUser(@PathVariable long id) {
        return userService.findByIdUser(id);
    }

}