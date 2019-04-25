package com.example.FitnessClub.service;

import com.example.FitnessClub.domain.Subscription;
import com.example.FitnessClub.domain.Role;
import com.example.FitnessClub.domain.Subscription;
import com.example.FitnessClub.domain.User;
import com.example.FitnessClub.repos.DescriptionRepo;
import com.example.FitnessClub.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;


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
        user.setRoles(Collections.singleton(Role.USER));

        userRepo.save(user);
        return true;
    }

    public boolean activateUser(User user) {
        String phone = user.getPhone();
        Subscription subscription = descRepo.findByPhone(phone);
        if (subscription == null){
            return false;
        }

        return true;
    }
}
