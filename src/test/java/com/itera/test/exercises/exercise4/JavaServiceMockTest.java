package com.itera.test.exercises.exercise4;

import org.junit.jupiter.api.Test;


// Extend with mockito (MockitoExtension)
class JavaServiceMockTest {
    // Mock the dummy repository

    @Test
    void testServiceBackendCheck() {
        // State that when the repository is up is called - return true

        // Create the service using the mocked repository

        // Assert that service.backendCheck returns true
    }

    @Test
    void testServiceBackendCheckFail() {
        // State that when the repository is up is called - return false

        // Create the service using the mocked repository

        // Assert that service.backendCheck returns false
    }
}
