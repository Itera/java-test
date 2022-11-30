package no.itera.test.repository;

import java.util.List;

import no.itera.test.domain.DataJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class DataJavaRepositoryIT {
    @Autowired
    private DataJavaRepository repository;

    @Test
    void dataWasLoaded() {
        List<DataJava> items = repository.findAll();

        Assertions.assertEquals(5, items.size());
    }
}
