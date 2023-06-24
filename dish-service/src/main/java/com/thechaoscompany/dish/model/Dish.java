package com.thechaoscompany.dish.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "dishes")
public class Dish {
    @Id
    private String id;
    private LocalDateTime creationDate;
    private String name;
    private Long restaurantId;
}
