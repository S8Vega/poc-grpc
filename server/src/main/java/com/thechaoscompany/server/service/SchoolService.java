package com.thechaoscompany.server.service;

import com.thechaoscompany.server.entities.SchoolEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SchoolService {
    CompletableFuture<SchoolEntity> save(SchoolEntity schoolEntity);

    CompletableFuture<SchoolEntity> getOneById(Long id);

    CompletableFuture<List<SchoolEntity>> getAll();

    CompletableFuture<SchoolEntity> update(SchoolEntity schoolEntity, Long id);

    CompletableFuture<SchoolEntity> delete(Long id);
}
