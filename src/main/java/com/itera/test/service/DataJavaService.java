package com.itera.test.service;

import java.util.List;
import java.util.Optional;

import com.itera.test.domain.DataJava;
import com.itera.test.repository.DataJavaRepository;

import org.springframework.stereotype.Service;

@Service
public class DataJavaService {
    private final DataJavaRepository repository;

    public DataJavaService(DataJavaRepository repository) {
        this.repository = repository;
    }

    public List<DataJava> allData() {
        return repository.findAll();
    }

    public Optional<DataJava> getData(long id) {
        return repository.findById(id);
    }
}
