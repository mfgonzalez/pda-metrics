package edu.unirriter.pdametrics.repository;

import edu.unirriter.pdametrics.domain.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MetricRepository extends JpaRepository<Metric, UUID> {
}
