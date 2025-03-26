package com.example.nextgig.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class JobDTO {
    @Id
    private String id;
    private String title;
    private String company;
    private String location;
    private String description;
    private List<String> skillsRequired;
    private String ownerId;
    private String jobType;
    private LocalDateTime postedDate;
    private LocalDateTime expiryDate;
}