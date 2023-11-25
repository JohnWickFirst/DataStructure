package com.hibernateDb.hbdb.Util;

import com.hibernateDb.hbdb.Entity.Profile;
import com.hibernateDb.hbdb.Entity.Tweet;
import com.hibernateDb.hbdb.EntityTweeter.FilterOutgoing;
import com.hibernateDb.hbdb.EntityTweeter.TweetIncoming;
import com.hibernateDb.hbdb.EntityTweeter.TweetOutgoing;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TweetUtil {

    public Tweet getTweet(TweetIncoming tweetIncoming){

        LocalDateTime dateTime=LocalDateTime.now();
        Tweet tweet=new Tweet(tweetIncoming.getTweet(), dateTime, tweetIncoming.getCategory());
        return tweet;
    }

    public TweetOutgoing getOutGoingTweet(Profile profile){

        List<FilterOutgoing> msg= new ArrayList<FilterOutgoing>();
        String shortName= profile.getShortName();

        for(Tweet tweet: profile.getTweet()){
            FilterOutgoing fo= new FilterOutgoing(tweet.getTweet(),tweet.getDateTime(),tweet.getCategory());
            msg.add(fo);
        }
        TweetOutgoing tweetOutgoing= new TweetOutgoing(msg,shortName);

        return tweetOutgoing;
    }

    public TweetOutgoing getOutGoingTweet(List<Profile> profileList, String shortName) {
        List<FilterOutgoing> msg= new ArrayList<FilterOutgoing>();
        for(Profile p: profileList){
            System.out.println(p.getShortName());
            for(Tweet tweet: p.getTweet()){
                FilterOutgoing fo= new FilterOutgoing(tweet.getTweet(),tweet.getDateTime(),tweet.getCategory());
                msg.add(fo);
            }
        }
        TweetOutgoing tweetOutgoing= new TweetOutgoing(msg,shortName);

        return tweetOutgoing;
    }
}
