package com.thechaoscompany.server.service;

import com.thechaoscompany.server.entities.School;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SchoolService {
    CompletableFuture<School> save(School school);

    CompletableFuture<School> getOneById(Long id);

    CompletableFuture<List<School>> getAll();

    CompletableFuture<School> update(School school, Long id);

    CompletableFuture<School> delete(Long id);
}
