package no.itera.test.service;

import static org.mockito.Mockito.when;

import no.itera.test.repository.DummyRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DummyJavaServiceMockTest {
    @Mock
    DummyRepository dummyRepository;

    @Test
    void testServiceBackendCheck() {
        when(dummyRepository.isUp()).thenReturn(true);

        DummyJavaService service = new DummyJavaService(dummyRepository);

        Assertions.assertThat(service.backendCheck()).isTrue();
    }

    @Test
    void testServiceBackendCheckFail() {
        when(dummyRepository.isUp()).thenReturn(false);

        DummyJavaService service = new DummyJavaService(dummyRepository);

        Assertions.assertThat(service.backendCheck()).isFalse();
    }
}
