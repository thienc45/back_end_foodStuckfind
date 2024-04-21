package com.example.foodtrucks.repository;

import com.example.foodtrucks.entity.ERole;
import com.example.foodtrucks.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
