package com.hibernateDb.hbdb.Service;

import com.hibernateDb.hbdb.Entity.User;
import com.hibernateDb.hbdb.Repository.UserRepo;
import com.hibernateDb.hbdb.Util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

   public static Logger log= Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepo repo;

    @Autowired
    private UserUtil util;

    public User getUser(String userId){
        User user=null;
        try {
            user = repo.getUser(userId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public boolean validateUser(User user){
        log.info("User Info for Validate : "+user);
        User dbUser= getUser(user.getUserId());
        log.info("Got user from DB : "+dbUser);
        return util.compare(user,dbUser);

    }

    public User setUser(User user){
        log.info("User Info : "+user);
        return repo.setUser(user);
    }

    public User deleteUser(User user){
        User userDb=getUser(user.getUserId());
        if(util.compare(user,userDb)){
            repo.deleteUser(user.getUserId());
        }
        return user;
    }

    // Thinking on This
    //public String setPassword(User user)


}
