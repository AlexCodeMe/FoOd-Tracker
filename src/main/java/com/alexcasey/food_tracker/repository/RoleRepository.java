package com.alexcasey.food_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexcasey.food_tracker.enums.RoleEnum;
import com.alexcasey.food_tracker.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(RoleEnum role);
    
}
