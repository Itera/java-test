package com.itera.test.exercises.exercise5;

import com.itera.test.domain.DataJava;
import com.itera.test.repository.DataJavaRepository;
import com.itera.test.service.DataJavaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaServiceMockTest {
    @Mock
    DataJavaRepository repository;

    // Create an ArgumentCaptor to capture a long

    @Test
    void testSingle() {
        // Use the captor instead of any to capture the ID passed
        when(repository.findById(any())).thenReturn(Optional.of(new DataJava(1L, "qwerty")));

        DataJavaService service = new DataJavaService(repository);

        Optional<DataJava> data = service.getData(1);

        Assertions.assertThat(data).isPresent();
        Assertions.assertThat(data.get().getId()).isEqualTo(1);
        Assertions.assertThat(data.get().getName()).isEqualTo("qwerty");
        // Assert that the captured ID is the expected value (1)

        verify(repository, times(1)).findById(any());
    }
}
