package com.example.FitnessClub.controller;

import com.example.FitnessClub.domain.Customer;
import com.example.FitnessClub.domain.Trainer;
import com.example.FitnessClub.domain.User;
import com.example.FitnessClub.repos.CustomerRepo;
import com.example.FitnessClub.repos.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/profileTrainer")
public class ProfileTrainerController {
    @Autowired
    private TrainerRepo trainerRepo;

    @GetMapping
    public String profile(@AuthenticationPrincipal User user,
                       Model model){
        Trainer trainer = trainerRepo.findByUser(user);
        model.addAttribute("trainer", trainer);
        return "profileTrainer";
    }

    @PostMapping
    public String customerSave(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String lastName,
            @RequestParam String qualification,
            Map<String, Object> model
    )  {

        Trainer trainer = trainerRepo.findByUser(user);

        if (trainer == null) {
            trainer = new Trainer(name, lastName, qualification, user);
        }
        else {
            trainer.setName(name);
            trainer.setLastName(lastName);
            trainer.setQualification(qualification);
        }
        trainerRepo.save(trainer);
        model.put("trainer", trainer);
        return "profileTrainer";
    }

}
