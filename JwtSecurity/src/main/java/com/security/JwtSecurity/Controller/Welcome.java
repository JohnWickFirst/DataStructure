package com.security.JwtSecurity.Controller;

import com.security.JwtSecurity.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @Autowired
    private JwtUtils jwtUtil;

    @GetMapping("/invalid")
    public String welcome() {
        return "Welcome to javatechie !!";
    }

    @GetMapping("/valid")
    public String isValidated(){
        return "Good validation works";
    }
}
