package com.example.ChallengeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
   private ChallengeService challengeService;

   public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;

    }

    @GetMapping("/challenges")
    public List<Challenge> getAll(){
        return challengeService.getAllChallenges();
    }


    @GetMapping("/challenges/{month}")
    public Challenge getChallenge(@PathVariable String month){
       Challenge challenge = challengeService.getChallenges(month);
       if(challenge != null){
           return challenge;
       }
        return null;
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if(isChallengeAdded){
            return "challenge added successfully";
        }
        else{
            return "not success";
        }

    }
}
