package com.springproject.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);


    Job getJobById(Long id);
    boolean deleteJobById(Long id);

    Job updateJobById(Long id,Job updatedJob);
}
