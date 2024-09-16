package com.alexcasey.food_tracker.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int fdcId;
    private boolean isCustom;
    private float calories;
    private float protein;
    private float carbs;
    private float fat;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodNutrient> foodNutrients;
}