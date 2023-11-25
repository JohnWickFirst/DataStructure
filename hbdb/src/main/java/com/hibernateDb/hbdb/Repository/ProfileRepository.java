package com.hibernateDb.hbdb.Repository;

import com.hibernateDb.hbdb.Entity.Profile;
import com.hibernateDb.hbdb.Entity.Tweet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProfileRepository {

    // Change the filed injection into Setter Injection later


    private Profile profile;

    @PersistenceContext
    @Autowired
    private EntityManager manager;

    //First going with some basic Operation


    public Profile createUser(Profile profile){
        manager.persist(profile);
        manager.close();
        return profile;
    }

    public Profile getProfile(String shortName){
        Profile profile=
                manager.createNamedQuery("findByShortName", Profile.class)
                .setParameter("shortName",shortName).getSingleResult();
        manager.close();


        System.out.println("Profile :"+profile);
        return profile;
    }

    public void saveTweet(Tweet tweet, String shortName){
        Profile profile=getProfile(shortName);
        profile.addTweet(tweet);
        manager.merge(profile);
        manager.close();
        return;
    }

    public List<String> searchProfile(){
        List<String> shortNames=manager.createNamedQuery("searchProfile", String.class).getResultList();
        return shortNames;
    }

    public void saveFollowerAndFollowee(String common  , String star){
        Profile user=this.getProfile(common);
        Profile acceptor=this.getProfile(star);

        user.setStar(star);
        acceptor.setCommon(common);

    }


}
