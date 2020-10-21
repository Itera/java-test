package no.itera.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import no.itera.test.domain.TestData;
import no.itera.test.repository.TestDataRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestDataServiceMockTest {
  @Mock
  TestDataRepository repository;

  @Captor
  ArgumentCaptor<Long> captor;

  @Test
  void testGetAll() {
    when(repository.findAll()).thenReturn(Collections.emptyList());

    TestDataService service = new TestDataService(repository);

    Assertions.assertThat(service.allData().size()).isZero();
  }

  @Test
  void testSingle() {
    when(repository.findById(captor.capture())).thenReturn(Optional.of(new TestData(1L, "qwerty")));

    TestDataService service = new TestDataService(repository);

    Optional<TestData> data = service.getData(1);

    Assertions.assertThat(data).isPresent();
    Assertions.assertThat(data.get().getId()).isEqualTo(1);
    Assertions.assertThat(data.get().getValue()).isEqualTo("qwerty");
  }

  @Test
  void testSingleNoHit() {
    when(repository.findById(any())).thenReturn(Optional.empty());

    TestDataService service = new TestDataService(repository);

    Assertions.assertThat(service.getData(1)).isEmpty();
  }
}
