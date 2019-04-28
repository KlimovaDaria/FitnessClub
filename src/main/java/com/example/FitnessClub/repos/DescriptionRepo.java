package com.example.FitnessClub.repos;

import com.example.FitnessClub.domain.Description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptionRepo extends JpaRepository<Description, Long> {
    Description findByPhone(String phone);
}
