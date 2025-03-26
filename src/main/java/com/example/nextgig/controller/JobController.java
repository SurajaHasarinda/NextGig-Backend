package com.example.nextgig.controller;

import com.example.nextgig.dto.JobDTO;
import com.example.nextgig.dto.JobSummaryDTO;
import com.example.nextgig.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/all")
    public ResponseEntity<List<JobSummaryDTO>> getAllJobs() {
        List<JobSummaryDTO> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @PostMapping("/create")
    public ResponseEntity<JobDTO> createJob(@RequestBody JobDTO jobDTO) {
        JobDTO newJob = jobService.createJob(jobDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newJob);
    }

    @GetMapping("/details/{jobId}")
    public ResponseEntity<JobDTO> getJobDetails(@PathVariable String jobId) {
        JobDTO job = jobService.getJobDetails(jobId);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/type/{jobType}")
    public ResponseEntity<List<JobSummaryDTO>> getJobsByType(@PathVariable String jobType) {
        List<JobSummaryDTO> jobs = jobService.getJobsByType(jobType);
        return ResponseEntity.ok(jobs);
    }

    // TODO
    // The user should only be able to update the job if they are the owner of the job
    @DeleteMapping("/delete/{jobId}")
    public String deleteJob(@PathVariable String jobId) {
        return "Delete job";
    }

    @GetMapping("/search/{keyword}")
    public List<JobSummaryDTO> searchJobs(@PathVariable String keyword) {
        return jobService.searchJobs(keyword);
    }

    // TODO
    @GetMapping("/recommend/{userId}")
    public String recommendJob(@PathVariable String userId) {
        return "Recommend job for user " + userId;
    }
}
