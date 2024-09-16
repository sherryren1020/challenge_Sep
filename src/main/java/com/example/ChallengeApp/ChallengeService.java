package com.example.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ChallengeService {
    private List<Challenge> challenges =
            new ArrayList<>();
    private Long nextId = 1l;

    public ChallengeService() {;
    }
    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addChallenge(Challenge challenge){
        if(challenge != null){
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else{
            return false;
        }

    }

    public Challenge getChallenges(String month) {
        for(Challenge challenge: challenges){
            if (challenge.getId().equals((month))) {
                return challenge;
            }
        }
        return null;
    }
}
