package edu.unirriter.pdametrics.domain;

import java.io.Serializable;

public class Alert implements Serializable {

    private String date;
    private Long timestamp;
    private String source;
    private String name;
    private String value;

    public Alert(String dateIso8601, Long timestamp, String source, String name, String value) {
        this.date = dateIso8601;
        this.timestamp = timestamp;
        this.source = source;
        this.name = name;
        this.value = value;
    }

    public String getDateIso8601() {
        return date;
    }

    public void setDateIso8601(String dateIso8601) {
        this.date = dateIso8601;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "date='" + date + '\'' +
                ", timestamp=" + timestamp +
                ", source='" + source + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
