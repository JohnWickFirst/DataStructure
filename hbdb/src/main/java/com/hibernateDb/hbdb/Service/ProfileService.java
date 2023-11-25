package com.hibernateDb.hbdb.Service;

import com.hibernateDb.hbdb.Entity.Log;
import com.hibernateDb.hbdb.Entity.Profile;
import com.hibernateDb.hbdb.Entity.Tweet;
import com.hibernateDb.hbdb.EntityTweeter.FollowUtility;
import com.hibernateDb.hbdb.EntityTweeter.TweetIncoming;
import com.hibernateDb.hbdb.EntityTweeter.TweetOutgoing;
import com.hibernateDb.hbdb.Repository.LogRepo;
import com.hibernateDb.hbdb.Repository.ProfileRepository;
import com.hibernateDb.hbdb.Repository.TweetRepo;
import com.hibernateDb.hbdb.Util.TweetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {


    @Autowired
    private ProfileRepository repo;

    @Autowired
    private TweetUtil util;

    @Autowired
    private TweetRepo tweetRepo;

    private LogRepo logRepo;

    // CreateAccount
    public  Profile createAccount(Profile profile){
        try {
            repo.createUser(profile);
            return profile;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public TweetOutgoing getProfile(String shortName){
        List<Profile> profileList= new ArrayList<>();
        Profile profile= repo.getProfile(shortName);
        profileList.add(profile);
        try{
            ArrayList<String> star=profile.getStar();

            for(int i=0;i<star.size();i++){
                if(star.get(i)!=null){
                    Profile temp=repo.getProfile(star.get(i));
                    profileList.add(temp);
                }
            }
        }catch (Exception e){
            System.out.println("No Star");
        }
        TweetOutgoing tweetOutgoing=util.getOutGoingTweet(profileList, profile.getShortName());
        return tweetOutgoing;
    }

    public void createTweet(@RequestBody TweetIncoming tweetIncoming){
        // check if time stamp is mentioned or provide date time stamp and the set the value
        Tweet tweet=util.getTweet(tweetIncoming);
        tweetRepo.saveTweet(tweet);
        String shortName=tweetIncoming.getShortName();
        repo.saveTweet(tweet,shortName);

        return ;
    }

    public List<Tweet> getAllTweet(){

        return tweetRepo.getAllTweet();
    }

    public List<String> searchProfile(){
        return repo.searchProfile();
    }

    public void saveFollowerAndFollowee(FollowUtility followUtility){
        String common=followUtility.getUserShortName();
        String star=followUtility.getFolloweeShortName();
        repo.saveFollowerAndFollowee(common ,star);

    }

    public void saveLog(Log log){
        logRepo.saveLog(log);
    }



}
