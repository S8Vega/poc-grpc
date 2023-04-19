package com.thechaoscompany.server.controller;


import com.thechaoscompany.server.entities.SchoolEntity;
import com.thechaoscompany.server.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("school")
public class SchoolController {
    @Autowired
    private SchoolService service;

    @PostMapping
    public CompletableFuture<ResponseEntity<SchoolEntity>> postRecord(@RequestBody SchoolEntity school) {
        return service.save(school).thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<?>> getAll() {
        return service.getAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<?>> update(@RequestBody SchoolEntity school, @PathVariable Long id) {
        return service.update(school, id).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<?>> delete(@PathVariable Long id) {
        return service.delete(id).thenApply(ResponseEntity::ok);
    }
}
