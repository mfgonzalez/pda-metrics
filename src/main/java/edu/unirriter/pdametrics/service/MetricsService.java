package edu.unirriter.pdametrics.service;

import edu.unirriter.pdametrics.domain.Metric;
import edu.unirriter.pdametrics.endpoint.CustomEndpoint;
import edu.unirriter.pdametrics.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MetricsService {

    @Autowired
    CustomEndpoint customEndpoint;

    @Autowired
    MetricRepository repository;

    public List<Metric> getAll() {
        return repository.findAll();
    }

    public Metric get(UUID id) {
        return repository.getOne(id);
    }

    public Metric create(Metric metric) {
        return repository.save(metric);
    }

    public Metric update(Metric metric) {
        return repository.save(metric);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}