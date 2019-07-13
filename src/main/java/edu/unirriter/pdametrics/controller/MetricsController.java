package edu.unirriter.pdametrics.controller;


import edu.unirriter.pdametrics.domain.Alert;
import edu.unirriter.pdametrics.domain.Metric;
import edu.unirriter.pdametrics.dto.MetricDto;
import edu.unirriter.pdametrics.service.MetricsService;
import org.apache.camel.ProducerTemplate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

@RestController
public class MetricsController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MetricsService metricService;

    @Autowired
    ProducerTemplate producerTemplate;

    @GetMapping(path = "/metrics")
    public List<Metric> getAll() {
        return metricService.getAll();
    }

    @GetMapping(path = "/metric/{id}")
    public Metric getById(@PathVariable("id") UUID id) {
        return metricService.get(id);
    }

    @PostMapping(path = "/metric")
    public Metric create(@RequestBody Metric metric) {
        producerTemplate.sendBody("{{route.from.metric}}", createAlert(metric));
        return metricService.create(metric);
    }

    @PutMapping(path = "/metric")
    public Metric update(@RequestBody Metric metric) {
        producerTemplate.sendBody("{{route.from.metric}}", createAlert(metric));
        return metricService.update(metric);
    }

    @DeleteMapping(path = "/metric/{id}")
    public void delete(@PathVariable("id") UUID id) {
        metricService.delete(id);
    }

    private Alert createAlert(Metric metric) {
        Date date = new Date();
        return new Alert(
                getIsoDateTime(date),
                date.getTime(),
                "grupo1",
                metric.getName(),
                String.valueOf(metric.getValue())
        );

    }

    private String getIsoDateTime(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        return df.format(date);
    }

}