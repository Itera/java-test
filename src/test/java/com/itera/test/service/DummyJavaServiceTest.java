package com.itera.test.service;

import com.itera.test.repository.DummyRepositoryImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DummyJavaServiceTest {
    @Test
    void testCalculation() {
        DummyJavaService service = new DummyJavaService(new DummyRepositoryImpl());

        Assertions.assertEquals(5, service.complexCalculation(2, 3));
    }
}
