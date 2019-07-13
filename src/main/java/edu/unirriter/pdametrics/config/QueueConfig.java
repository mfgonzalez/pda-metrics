package edu.unirriter.pdametrics.config;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class QueueConfig {
    private static final String AMQP_SERVICE_PROTOCOL = "amqps";
    private static final String AMQP_SERVICE_PORT = "5671";

    @Autowired
    private Environment env;

    @Bean
    AMQPConnectionDetails securedAmqpConnection() {

        String amqpPwd = env.getProperty("AMQP_SERVICE_PASSWORD");
        String amqpHost = env.getProperty("AMQP_SERVICE_HOST");
        String amqpUser = env.getProperty("AMQP_SERVICE_USERNAME");

        String uri = AMQP_SERVICE_PROTOCOL + "://" + amqpHost + ":" + AMQP_SERVICE_PORT;
        return new AMQPConnectionDetails(uri, amqpUser, amqpPwd);
    }

}