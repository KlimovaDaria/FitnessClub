package com.example.FitnessClub.controller;

import com.example.FitnessClub.domain.*;
import com.example.FitnessClub.repos.CustomerRepo;
import com.example.FitnessClub.repos.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Trainer> trainers  = trainerRepo.findAll();

        model.addAttribute("trainers", trainers);
        model.addAttribute("filter", filter);

        return "main";
    }


    /*@PostMapping("/main")
    public String add( @AuthenticationPrincipal User user){
        Customer customer = customerRepo.findByUser(user);
        Trainer trainer = trainerRepo.
        trainerRepo.save(customer);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }*/
}