package edu.unirriter.pdametrics.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Metric {

    @Id
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

    @Override
    public String toString() {
        return "Metric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

}