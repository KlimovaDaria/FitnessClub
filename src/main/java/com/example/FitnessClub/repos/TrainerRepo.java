package com.example.FitnessClub.repos;

import com.example.FitnessClub.domain.Trainer;
import com.example.FitnessClub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {
        Trainer findByUser(User user);

        List<Trainer> findByQualification(String qualification);
        }

