package com.hibernateDb.hbdb.Repository;

import com.hibernateDb.hbdb.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserRepo {

    private User user;

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    public User getUser(String userId){
        User user=entityManager.createNamedQuery("findUserById", User.class).setParameter("userId",userId).
                getSingleResult();
        entityManager.close();
        return user;
    }

    public User setUser(User user){

        entityManager.persist(user);

        entityManager.close();
        return user;
    }

    public User deleteUser(String userId){
        User user=getUser(userId);
        if(user==null){
            return null;
        }
        entityManager.createNamedQuery("deleteUserById").
                setParameter("userId", userId).executeUpdate();
        entityManager.close();
        return user;
    }


}
