package com.hibernateDb.hbdb.Controller;

import com.hibernateDb.hbdb.Entity.User;
import com.hibernateDb.hbdb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Information {


    @Autowired
    private UserService userService;

    @PostMapping("/users/validate")
    public boolean validateUser(@RequestBody User user){

        return userService.validateUser(user);

    }

    @PostMapping("/users")
    public User setUser(@RequestBody User user){
        return userService.setUser(user);
    }

    @GetMapping("/users")
    public User getUser(String  userId){
        return userService.getUser(userId);
    }

    public User deleteUser(User user){
        return userService.deleteUser(user);
    }

    @GetMapping("/get")
    public String welCOme(){
        return "Welcome to the Page of Bank of Test";

    }

    @GetMapping("/testConnectivity")
    public String test(){
        return "Connected Successfully ";
    }
}
