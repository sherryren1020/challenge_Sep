package com.example.ChallengeApp;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge,Long> {


    Optional<Challenge> findByMonthIgnoreCase(String month);
}
