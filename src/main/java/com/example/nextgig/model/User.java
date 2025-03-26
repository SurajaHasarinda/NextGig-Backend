package com.example.nextgig.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@Builder
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String name;

    private String pictureUrl;

    @Indexed(unique = true)
    private String googleId;
}
