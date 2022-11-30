package no.itera.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import no.itera.test.domain.DataJava;
import no.itera.test.repository.DataJavaRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataJavaServiceMockTest {
  @Mock
  DataJavaRepository repository;

  @Captor
  ArgumentCaptor<Long> captor;

  @Test
  void testGetAll() {
    when(repository.findAll()).thenReturn(Collections.emptyList());

    DataJavaService service = new DataJavaService(repository);

    Assertions.assertThat(service.allData().size()).isZero();
  }

  @Test
  void testSingle() {
    when(repository.findById(captor.capture())).thenReturn(Optional.of(new DataJava(1L, "qwerty")));

    DataJavaService service = new DataJavaService(repository);

    Optional<DataJava> data = service.getData(1);

    Assertions.assertThat(data).isPresent();
    Assertions.assertThat(data.get().getId()).isEqualTo(1);
    Assertions.assertThat(data.get().getName()).isEqualTo("qwerty");
    Assertions.assertThat(captor.getValue()).isEqualTo(1L);
    verify(repository, times(1)).findById(any());
  }

  @Test
  void testSingleNoHit() {
    when(repository.findById(any())).thenReturn(Optional.empty());

    DataJavaService service = new DataJavaService(repository);

    Assertions.assertThat(service.getData(1)).isEmpty();
    verify(repository, times(1)).findById(any());
  }
}
