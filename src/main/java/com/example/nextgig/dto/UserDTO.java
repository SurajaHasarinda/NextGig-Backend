package com.example.nextgig.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Builder
public class UserDTO {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String name;

    private String pictureUrl;

    @Indexed(unique = true)
    private String googleId;
}
