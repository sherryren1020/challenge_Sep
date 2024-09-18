package com.example.ChallengeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
   private ChallengeService challengeService;

   public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;

    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAll(){
        return  new ResponseEntity(challengeService.getAllChallenges(),HttpStatus.OK);
    }


    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
       Challenge challenge = challengeService.getChallenges(month);
       if(challenge != null){
           return new ResponseEntity<>(challenge, HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if(isChallengeAdded){
            return new ResponseEntity<>("challenge added successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not add successfully",HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
       boolean isChallengeUpdated = challengeService.updateChallenge(id,updatedChallenge);
        if(isChallengeUpdated){
            return new ResponseEntity<>("Updaed", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found ", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
       boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Deleted ", HttpStatus.NOT_FOUND);

    }
}
