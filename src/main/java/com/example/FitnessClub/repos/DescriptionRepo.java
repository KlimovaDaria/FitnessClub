package com.example.FitnessClub.repos;

import com.example.FitnessClub.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptionRepo extends JpaRepository<Subscription, Long> {
    Subscription  findByPhone(String phone);
}
