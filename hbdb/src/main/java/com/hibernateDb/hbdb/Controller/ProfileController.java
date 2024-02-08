package com.hibernateDb.hbdb.Controller;

import com.hibernateDb.hbdb.Entity.Log;
import com.hibernateDb.hbdb.Entity.Profile;
import com.hibernateDb.hbdb.Entity.Tweet;
import com.hibernateDb.hbdb.EntityTweeter.FollowUtility;
import com.hibernateDb.hbdb.EntityTweeter.TweetIncoming;
import com.hibernateDb.hbdb.EntityTweeter.TweetOutgoing;
import com.hibernateDb.hbdb.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @PostMapping("/accounts")
    public Profile createAccount(@RequestBody Profile profile){
      return service.createAccount(profile);

    }

    @GetMapping("/accounts/{shortName}")
    public TweetOutgoing getProfile(@PathVariable("shortName") String shortName){

        return service.getProfile(shortName);
    }

    // currently giving random name will change back to standard api
    @PutMapping("/createTweet")
    public String createTweet(@RequestBody TweetIncoming tweet){
        service.createTweet(tweet);
        return "Created Successfully !";

    }

    // Not working
    @GetMapping("/tweets")
    public List<Tweet> getAllTweet(){
        return service.getAllTweet();
    }



    @GetMapping("/accounts/demo/{shortName}")
    public String demo(@PathVariable("shortName") String shortName){
        System.out.println(service.getProfile(shortName));
        return "found";
    }

    @GetMapping("/searchProfile")
    public List<String> searchProfile(){

        return service.searchProfile();
    }

    @PostMapping("/follow")
    public String follow(@RequestBody FollowUtility followUtility){
        service.saveFollowerAndFollowee(followUtility);
        return "Follow And Followee Success";
    }

    @PostMapping("/log")
    public void saveLog(@RequestBody Log log){
        service.saveLog(log);
    }


}
