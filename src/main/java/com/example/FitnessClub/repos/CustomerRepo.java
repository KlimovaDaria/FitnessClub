package com.example.FitnessClub.repos;

import com.example.FitnessClub.domain.Customer;
import com.example.FitnessClub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByUser(User user);
}
