package com.security.JwtSecurity.Controller;

import com.security.JwtSecurity.AuthUtils.UserAuth;
import com.security.JwtSecurity.Config.SpringSecurity;
import com.security.JwtSecurity.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identity")
public class JwtToken {

    @Autowired
    private JwtUtils jwtUtils;


    @Autowired
    private SpringSecurity springSecurity;

    @PostMapping("/getToken")
    public String getToken(@RequestBody UserAuth userAuth){

        if(!springSecurity.authenticateUser(userAuth)){
            return null;
        }

        try {
            springSecurity.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuth.getUserName(),userAuth.getPassword())
            );
        }catch (Exception e){
            return null;

        }
        return jwtUtils.generateToken(userAuth.getUserName());
    }

    // For now creating get method to validate token later will change
    @GetMapping("/validateToken/{token}")
    public Boolean validateToken(@PathVariable String token){
        return jwtUtils.validateToken(token);
    }

}
