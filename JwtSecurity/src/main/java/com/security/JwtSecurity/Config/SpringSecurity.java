package com.security.JwtSecurity.Config;


import com.security.JwtSecurity.AuthUtils.UserAuth;
import com.security.JwtSecurity.Entity.User;
import com.security.JwtSecurity.Repository.UserRepo;
import com.security.JwtSecurity.Service.CustomDetailUserService;
import org.apache.logging.log4j.LogManager;

import com.security.JwtSecurity.Entity.User;
import com.security.JwtSecurity.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;


@Component
public class SpringSecurity implements AuthenticationProvider {

    @Autowired

    private CustomDetailUserService userRepo;

    private UserRepo userRepo;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName=authentication.getName();
        String pwd=authentication.getCredentials().toString();


        try {
            UserDetails user = userRepo.loadUserByUsername(userName);
            System.out.println(user.toString());

            if (user == null) {
                throw new BadCredentialsException("User is not enetered");
            } else {
                if (pwd.equals(user.getPassword())) {
                    return new UsernamePasswordAuthenticationToken(userName, pwd);
                } else {
                    throw new BadCredentialsException("Password creaadentials is wrong");
                }
            }
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean authenticateUser(UserAuth userAuth){
        String userName=userAuth.getUserName();
        String pwd=userAuth.getPassword();

        UserDetails user = userRepo.loadUserByUsername(userName);

        if (user == null || !user.getPassword().equals(pwd)) {
                return false;
        }


        return true;

        User user=userRepo.getUser(userName);
        if(user==null){
            throw new BadCredentialsException("User is not enetered");
        }else{
            if(pwd.equals(user.getPassword())){
                List<SimpleGrantedAuthority> list= new ArrayList<>();
                SimpleGrantedAuthority auth= new SimpleGrantedAuthority("USER");
                list.add(auth);
                return new UsernamePasswordAuthenticationToken(userName, pwd,list);

            }else{
                throw new BadCredentialsException("Password creaadentials is wrong");
            }
        }

    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
