package com.hibernateDb.hbdb.Repository;

import com.hibernateDb.hbdb.Entity.Profile;
import com.hibernateDb.hbdb.Entity.Tweet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TweetRepo {

    private Tweet tweet;

    @Autowired
    @PersistenceContext
    private EntityManager manager;

    public Tweet saveTweet( Tweet tweet){
        manager.persist(tweet);
        manager.close();
        return tweet;
    }
    public List<Tweet> getAllTweet(){
        List<Tweet> tweetList= manager.createNamedQuery("getTweet", Tweet.class)
                .getResultList();
        manager.close();
        return tweetList;
    }
}
