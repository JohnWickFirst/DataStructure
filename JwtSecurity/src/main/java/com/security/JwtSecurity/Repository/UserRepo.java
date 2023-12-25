package com.security.JwtSecurity.Repository;

import com.security.JwtSecurity.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserRepo {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    public User getUser(String userId){
        User user=entityManager.createNamedQuery("findUserById", User.class).setParameter("userId",userId).
                getSingleResult();
        entityManager.close();
        return user;
    }

    public void setUser(User user){
        entityManager.persist(user);
        entityManager.close();
        return ;
    }
}
