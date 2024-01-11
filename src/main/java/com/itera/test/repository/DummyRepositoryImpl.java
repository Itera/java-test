package com.itera.test.repository;

import org.springframework.stereotype.Component;

@Component
public class DummyRepositoryImpl implements DummyRepository {
    @Override
    public boolean isUp() {
        return true;
    }
}
