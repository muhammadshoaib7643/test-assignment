package com.example.test_assignment.controller;

import com.example.test_assignment.dto.ApiResponse;
import com.example.test_assignment.entity.Client;
import com.example.test_assignment.service.ClientService;
import com.example.test_assignment.service.ExternalApiService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ExternalApiService externalApiService;

    @PostMapping
    public ResponseEntity<ApiResponse<Client>> create(
            @RequestBody Client client
    ) {
        Client saved = clientService.create(client);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Client created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Client>>> getAll(
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Client> result = clientService.getAll(pageable);

        return ResponseEntity.ok(
                new ApiResponse<>("Clients fetched successfully", result)
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Client>> update(
            @PathVariable Long id,
            @RequestBody Client client
    ) {
        Client updated = clientService.update(id, client);
        return ResponseEntity.ok(
                new ApiResponse<>("Client updated successfully", updated)
        );
    }

    // Nested API call
    @GetMapping("/external")
    public ResponseEntity<ApiResponse<String>> callExternalApi() {
        String response = externalApiService.callExternal();
        return ResponseEntity.ok(
                new ApiResponse<>("External API call successful", response)
        );
    }
}

