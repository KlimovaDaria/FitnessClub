package com.example.FitnessClub.controller;

import com.example.FitnessClub.domain.Customer;
import com.example.FitnessClub.domain.Message;
import com.example.FitnessClub.domain.User;
import com.example.FitnessClub.repos.CustomerRepo;
import com.example.FitnessClub.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping
    public String profile(@AuthenticationPrincipal User user,
                       Model model){
        Customer customer = customerRepo.findByUser(user);
        model.addAttribute("customer", customer);
        return "profile";
    }

    @PostMapping
    public String customerSave(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String lastName,
            @RequestParam String objective,
            @RequestParam float weight,
            @RequestParam float growth,
            Map<String, Object> model
    )  {

        Customer customer = customerRepo.findByUser(user);

        if (customer == null) {
            customer = new Customer(user,name, lastName, objective,weight,growth);
        }
        else {
            customer.setName(name);
            customer.setLastName(lastName);
            customer.setObjective(objective);
            customer.setWeight(weight);
            customer.setGrowth(growth);
        }
        customerRepo.save(customer);
        model.put("customer", customer);
        return "profile";
    }

}
