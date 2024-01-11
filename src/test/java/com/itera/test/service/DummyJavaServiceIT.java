package com.itera.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DummyJavaServiceIT {
    @Autowired
    private DummyJavaService service;

    @Test
    void testStatus() {
        boolean result = service.backendCheck();

        Assertions.assertTrue(result);
    }
}
