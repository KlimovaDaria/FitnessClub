package com.example.FitnessClub.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private  String name;
    private String lastName;
    private String objective;
    private float weight;
    private float growth;

    @ManyToMany
    @JoinTable(
            name = "SignUp_Trainer",
            joinColumns = { @JoinColumn(name = "trainer_id") },
            inverseJoinColumns = { @JoinColumn(name = "customer_id") }
    )
    private Set<Trainer> trainers = new HashSet<>();

    public Customer() {
    }

    public Customer(User user, String name, String userName, String objective, float weight, float growth ) {
        this.user = user;
        this.name = name;
        this.lastName = userName;
        this.objective = objective;
        this.weight = weight;
        this.growth = growth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getGrowth() {
        return growth;
    }

    public void setGrowth(float growth) {
        this.growth = growth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
