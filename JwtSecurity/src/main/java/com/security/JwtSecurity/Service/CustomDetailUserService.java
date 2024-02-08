package com.security.JwtSecurity.Service;

import com.security.JwtSecurity.Entity.User;
import com.security.JwtSecurity.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomDetailUserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User authUser= userRepo.getUser(username);

        if(authUser!=null){
          return new org.springframework.security.core.userdetails.
                    User(authUser.getUserName(), authUser.getPassword(), new ArrayList<>());
        }
        return null;
    }

}
