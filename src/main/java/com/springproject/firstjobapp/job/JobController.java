package com.springproject.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import  java.util.*;
@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);

        return new ResponseEntity<>("Job created Successfully",HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getJobById(@PathVariable Long id){

        Job job = jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>("No job with id "+id+" is found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean delete=jobService.deleteJobById(id);
        if(delete){
            return new ResponseEntity<>("Job with id  "+id +" is deleted.",HttpStatus.OK);
        }
        return new ResponseEntity<>("No job with id "+ id +" is found",HttpStatus.NOT_FOUND);
    }
    @PutMapping("{id}")
    public ResponseEntity<Object> updateJob(@PathVariable Long id ,@RequestBody Job updatedJob){
        Job job=jobService.updateJobById(id,updatedJob);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No job with id "+id+ " is found",HttpStatus.NOT_FOUND);
    }

}
