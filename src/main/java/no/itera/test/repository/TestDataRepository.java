package no.itera.test.repository;

import no.itera.test.domain.TestData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDataRepository extends JpaRepository<TestData, Long> {
}
