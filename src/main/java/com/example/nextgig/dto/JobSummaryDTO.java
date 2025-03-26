package com.example.nextgig.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
public class JobSummaryDTO {
    @Id
    private String id;
    private String title;
    private String company;
    private String location;
    private String jobType;
    private LocalDateTime postedDate;
}