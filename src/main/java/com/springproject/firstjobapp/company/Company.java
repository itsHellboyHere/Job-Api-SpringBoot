package com.springproject.firstjobapp.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springproject.firstjobapp.job.Job;
import com.springproject.firstjobapp.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Job> jobs;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Company() {
    }

//    public Company(Long id, String name, String description, List<Job> jobs) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.jobs = jobs;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}