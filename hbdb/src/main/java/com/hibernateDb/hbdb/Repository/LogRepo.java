package com.hibernateDb.hbdb.Repository;

import com.hibernateDb.hbdb.Entity.Log;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LogRepo {

    private EntityManager entityManager;

    @Autowired
    private void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void saveLog(Log log){
        entityManager.persist(log);
        entityManager.close();
    }
}
