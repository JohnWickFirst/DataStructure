package com.security.JwtSecurity.Controller;

import com.security.JwtSecurity.Entity.User;
import com.security.JwtSecurity.Service.UserService;
import com.security.JwtSecurity.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class Welcome {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User signUpUser(@RequestBody User user){
        return userService.setUser(user);
    }

    @PutMapping("/users")
    public User resetPassword(@RequestBody User user){
        return userService.setUser(user);
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username){

        return userService.getUser(username);
    }

    @GetMapping("/invalid")
    public String welcome() {
        return "Welcome to javatechie !!";
    }

    @GetMapping("/valid")
    public String isValidated(){
        return "Good validation works";
    }


}
