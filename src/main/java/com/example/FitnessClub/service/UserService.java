package com.example.FitnessClub.service;

import com.example.FitnessClub.domain.*;
import com.example.FitnessClub.repos.CustomerRepo;
import com.example.FitnessClub.repos.DescriptionRepo;
import com.example.FitnessClub.repos.TrainerRepo;
import com.example.FitnessClub.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private DescriptionRepo descRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepo.findByUsername(userName);
    }

    public boolean addUser(User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setActive(true);
        String phone = user.getPhone();
        Description description = descRepo.findByPhone(phone);
         if (description.getRoles() == "TRAINER")
         {
           user.setRoles(Collections.singleton(Role.TRAINER));
         }
        else if(description.getRoles() == "USER")
        {
            user.setRoles(Collections.singleton(Role.USER));
        }

        userRepo.save(user);
        return true;
    }

    public boolean activateUser(User user) {
        String phone = user.getPhone();
        Description description = descRepo.findByPhone(phone);
        if (description == null){
            return false;
        }

        return true;
    }
}
