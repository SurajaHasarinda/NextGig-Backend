package com.example.nextgig.repository;

import com.example.nextgig.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {
    List<Job> findByJobType(String jobType);

    @Query("{ '$or': [ " +
            "  { 'title': { $regex: ?0, $options: 'i' } }, " +
            "  { 'skillsRequired': { $regex: ?0, $options: 'i' } }, " +
            "  { 'company': { $regex: ?0, $options: 'i' } }, " +
            "  { 'jobType': { $regex: ?0, $options: 'i' } } " +
            "] }")
    List<Job> findByKeyword(String keyword);
}
