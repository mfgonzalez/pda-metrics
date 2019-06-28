package edu.unirriter.pdametrics.domain;

import java.util.UUID;

public class Metric {

    private UUID id;
    private String name;
    private Long value;

    public Metric() {
        this.id = UUID.randomUUID();
    }

    public Metric(String name, Long value) {
        this();
        this.name = name;
        this.value = value;
    }

    public Metric(UUID id, String name, Long value) {
        this(name, value);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getValue() {
        return value;
    }

    public UUID getId() {
        return id;
    }
}