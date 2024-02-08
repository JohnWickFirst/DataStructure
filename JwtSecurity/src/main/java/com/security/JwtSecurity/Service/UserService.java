package com.security.JwtSecurity.Service;

import com.security.JwtSecurity.Entity.User;
import com.security.JwtSecurity.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;
    private LocalDate localDate;

    @Autowired
    private void setUserRepo(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public User setUser(User user){
        if(user.getDate()==null){
            LocalDate date=LocalDate.now();
            user.setDate(date);
        }
        userRepo.setUser(user);
        return  user;
    }

    public User getUser(String userName){
        User user=userRepo.getUser(userName);
        return user;
    }

    public List<User> getAllUser(){
        return userRepo.getAllUser();
    }

    public boolean setEnabled(User user1){
        try{
            User user2=getUser(user1.getUserName());
            Boolean isValid=validateUser(user1,user2);
            if(!isValid){
                throw new RuntimeException("Invalid Data");
            }

            user1.setDate(LocalDate.now());
            userRepo.setUser(user1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    private boolean validateUser(User user1, User user2){
        if(user2==null || user1==null){
            return false;
        }
        if(user2.getUserName().equals(user1.getUserName())
        && user2.getPassword().equals(user1.getPassword())){
            return true;
        }
        return false ;
    }

}
