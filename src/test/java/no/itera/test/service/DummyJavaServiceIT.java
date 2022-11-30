package no.itera.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DummyJavaServiceIT {
    @Autowired
    private DummyJavaService service;

    @Test
    void testStatus() throws Exception {
        boolean result = service.backendCheck();

        assertEquals(result, true);
    }
}
