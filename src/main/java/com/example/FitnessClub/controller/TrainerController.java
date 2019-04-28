package com.example.FitnessClub.controller;

import com.example.FitnessClub.domain.Customer;
import com.example.FitnessClub.domain.Trainer;
import com.example.FitnessClub.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
    @RequestMapping("/trainer")
    @GetMapping("/trainer")
    public String trainerForm(@PathVariable Trainer trainer, Model model){
        model.addAttribute("trainer", trainer);
        return "/trainer" + trainer.getId();
    }

    @PostMapping("/trainer")
    public String signUp(
            @AuthenticationPrincipal User user,
            @RequestParam Map<String, String> form,
            @RequestParam("trainerId") Trainer trainer){
       // Customer customer = customerRepo.findByUser(user);
        /*customer.set
        user.setUsername(userName);
        user.setEmail(email);
        user.setEmail(phone);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();
        for (String key: form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);*/
        return "redirect:/user";
    }

}
