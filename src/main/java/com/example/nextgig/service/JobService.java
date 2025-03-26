package com.example.nextgig.service;

import com.example.nextgig.dto.JobDTO;
import com.example.nextgig.dto.JobSummaryDTO;
import com.example.nextgig.model.Job;
import com.example.nextgig.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    private JobSummaryDTO convertToSummaryDTO(Job job) {
        return JobSummaryDTO.builder()
                .id(job.getId())
                .title(job.getTitle())
                .company(job.getCompany())
                .location(job.getLocation())
                .jobType(job.getJobType())
                .postedDate(job.getPostedDate())
                .build();
    }

    private JobDTO convertToDTO(Job job) {
        return JobDTO.builder()
                .id(job.getId())
                .title(job.getTitle())
                .company(job.getCompany())
                .location(job.getLocation())
                .description(job.getDescription())
                .skillsRequired(job.getSkillsRequired())
                .ownerId(job.getOwnerId())
                .jobType(job.getJobType())
                .postedDate(job.getPostedDate())
                .expiryDate(job.getExpiryDate())
                .build();
    }

    public List<JobSummaryDTO> getAllJobs() {
        List<Job> allJobs = jobRepository.findAll();
        return allJobs.stream().map(this::convertToSummaryDTO).toList();
    }

    public JobDTO createJob(JobDTO jobDTO) {
        try {
            Job job = Job.builder()
                    .title(jobDTO.getTitle())
                    .company(jobDTO.getCompany())
                    .location(jobDTO.getLocation())
                    .description(jobDTO.getDescription())
                    .skillsRequired(jobDTO.getSkillsRequired())
                    .ownerId(jobDTO.getOwnerId())
                    .jobType(jobDTO.getJobType())
                    .postedDate(jobDTO.getPostedDate())
                    .expiryDate(jobDTO.getExpiryDate())
                    .build();
            Job savedJob = jobRepository.save(job);
            return convertToDTO(savedJob);
        } catch (Exception e) {
            throw new RuntimeException("Error creating job", e);
        }
    }

    public JobDTO getJobDetails(String jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        return convertToDTO(job);
    }

    public List<JobSummaryDTO> getJobsByType(String jobType) {
        List<Job> jobs = jobRepository.findByJobType(jobType);
        return jobs.stream().map(this::convertToSummaryDTO).toList();
    }

    public List<JobSummaryDTO> searchJobs(String keyword) {
        List<Job> jobs = jobRepository.findByKeyword(keyword);
        return jobs.stream().map(this::convertToSummaryDTO).toList();
    }


//
//    public List<Job> recommendJobs(List<String> skills) {
//        return jobRepository.findBySkillsRequiredIn(skills);
}

