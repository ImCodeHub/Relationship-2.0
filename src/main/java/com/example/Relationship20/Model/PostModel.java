package com.example.Relationship20.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostModel {
    private Long userId;
    private String title;
    private String description;
    private LocalDateTime dateTime;
}
