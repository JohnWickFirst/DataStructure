package com.hibernateDb.hbdb.Util;

import com.hibernateDb.hbdb.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    public Boolean compare(User userInfoProvided, User userInfoInDB){
        if(userInfoProvided==null || userInfoInDB ==null){
            return false;
        }
        if( !userInfoInDB.getPassword().equals(userInfoProvided.getPassword())){
            return false;
        }
        if(!userInfoInDB.isEnabled()){
            return false;
        }

        return true;


    }

}
