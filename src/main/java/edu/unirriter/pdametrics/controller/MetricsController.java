package edu.unirriter.pdametrics.controller;


import edu.unirriter.pdametrics.domain.Metric;
import edu.unirriter.pdametrics.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MetricsController {

    @Autowired
    private MetricsService metricService;

    @GetMapping(path = "/metric")
    public List<Metric> getAll() {
        return metricService.getAll();
    }

    @GetMapping(path = "/metric/{id}")
    public Metric getById(@PathVariable("id") UUID id) {
        return metricService.get(id);
    }

    @PostMapping(path = "/metric")
    public Metric create(@RequestBody Metric metric) {
        return metricService.create(metric);
    }

    @DeleteMapping(path = "/metric/{id}")
    public void delete(@PathVariable("id") UUID id) {
        metricService.delete(id);
    }
}