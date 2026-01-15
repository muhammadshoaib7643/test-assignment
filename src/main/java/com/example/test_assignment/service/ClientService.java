package com.example.test_assignment.service;

import com.example.test_assignment.entity.Client;
import com.example.test_assignment.repository.ClientRepository;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    @Transactional
    public Client create(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Transactional(readOnly = true)
    public Page<Client> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Client update(Long id, Client updated) {
        Client existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setUpdatedAt(LocalDateTime.now());
        return repository.save(existing);
    }
}
