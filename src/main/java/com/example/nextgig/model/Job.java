package com.example.nextgig.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "job")
@Data
@Builder
public class Job {
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

