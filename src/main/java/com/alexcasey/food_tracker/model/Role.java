package com.alexcasey.food_tracker.model;

import java.util.Collection;
import java.util.HashSet;

import com.alexcasey.food_tracker.enums.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private RoleEnum role;
    
    public Role(RoleEnum role) {
        this.role = role;
    }

    @ManyToMany(mappedBy = "roles")
    private Collection<Account> accounts = new HashSet<>();
}