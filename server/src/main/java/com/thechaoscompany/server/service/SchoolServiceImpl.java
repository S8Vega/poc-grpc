package com.thechaoscompany.server.service;

import com.thechaoscompany.server.entities.SchoolEntity;
import com.thechaoscompany.server.repository.SchoolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolsRepository;

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<SchoolEntity> save(SchoolEntity school) {
        school.setStatus(1);
        return CompletableFuture.completedFuture(schoolsRepository.save(school));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<SchoolEntity> getOneById(Long id) {
        Optional<SchoolEntity> school = schoolsRepository.findById(id);
        return CompletableFuture.completedFuture(school.orElse(null));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<SchoolEntity>> getAll() {
        return CompletableFuture.completedFuture(schoolsRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<SchoolEntity> update(SchoolEntity school, Long id) {
        SchoolEntity findStudent = schoolsRepository.getById(id);
        if (findStudent.getId() != null) {
            ModelMapper modelMapper = new ModelMapper();
            SchoolEntity updateStudent = modelMapper.map(findStudent, SchoolEntity.class);
            return CompletableFuture.completedFuture(schoolsRepository.save(updateStudent));
        } else {
            return null;
        }
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<SchoolEntity> delete(Long id) {
        SchoolEntity findStudent = schoolsRepository.getById(id);
        if (findStudent.getId() != null) {
            findStudent.setStatus(0);
            return CompletableFuture.completedFuture(schoolsRepository.save(findStudent));
        } else {
            return null;
        }
    }
}
