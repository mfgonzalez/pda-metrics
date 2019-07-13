package edu.unirriter.pdametrics.endpoint;

import edu.unirriter.pdametrics.domain.Metric;
import edu.unirriter.pdametrics.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Endpoint(id="custom-metric")
public class CustomEndpoint {

    @Autowired
    MetricsService service;

    @ReadOperation
    public List<Metric> getMetrics() {
        return service.getAll();
    }


}
