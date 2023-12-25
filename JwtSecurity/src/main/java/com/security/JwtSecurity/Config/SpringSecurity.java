package com.security.JwtSecurity.Config;

import com.security.JwtSecurity.Entity.User;
import com.security.JwtSecurity.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringSecurity implements AuthenticationProvider {

    @Autowired
    private UserRepo userRepo;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName=authentication.getName();
        String pwd=authentication.getCredentials().toString();
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
