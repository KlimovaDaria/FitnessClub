package com.example.FitnessClub.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private  String name;
    private String lastName;
    private String qualification;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "SignUp_Trainer",
            joinColumns = { @JoinColumn(name = "customer_id") },
            inverseJoinColumns = { @JoinColumn(name = "trainer_id") }
    )
    private Set<Customer> customers = new HashSet<>();

    public Trainer() {
    }

    public Trainer(String name, String lastName, String qualification, User user) {
        this.name = name;
        this.lastName = lastName;
        this.qualification = qualification;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
