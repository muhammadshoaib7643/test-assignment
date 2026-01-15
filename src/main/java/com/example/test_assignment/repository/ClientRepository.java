package com.example.test_assignment.repository;

import com.example.test_assignment.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
