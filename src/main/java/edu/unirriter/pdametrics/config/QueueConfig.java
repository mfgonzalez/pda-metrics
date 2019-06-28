package edu.unirriter.pdametrics.config;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
    Estabelece a configuração para acessar a fila AMQP na Amazon.
    Importante: não comitar o usuário e senha em AMQP_SERVICE_USERNAME e AMQP_SERVICE_PASSWORD. Deverá passar os parâmetros
    System.getenv("user"); e System.getenv("pass"); que serão alimentados pelas variáveis do Heroku.
*/
@Component
public class QueueConfig {

    private static final String AMQP_SERVICE_HOST = "b-79e24b8a-cd93-48a3-b234-9d75e05e3def-1.mq.us-east-1.amazonaws.com";
    private static final String AMQP_SERVICE_PORT = "5671";
    private static final String AMQP_SERVICE_USERNAME = System.getenv("user");
    private static final String AMQP_SERVICE_PASSWORD = System.getenv("pass");

    @Value("${ampq.service.username}")
    private String userAmq;

    @Value("${ampq.service.password}")
    private String passwAmq;

    public AMQPConnectionDetails securedAmqpConnection() {
        if (null != AMQP_SERVICE_USERNAME) {
            System.out.println(">> user from HEROKU");
            setUserAmq(AMQP_SERVICE_USERNAME);
        }

        if (null != AMQP_SERVICE_PASSWORD) {
            System.out.println(">> pass from HEROKU");
            setPasswAmq(AMQP_SERVICE_PASSWORD);
        }

        return new AMQPConnectionDetails("amqps://" + AMQP_SERVICE_HOST+":" + AMQP_SERVICE_PORT,
                getUserAmq(),
                getPasswAmq());
    }

    private String getUserAmq() {
        return userAmq;
    }

    private void setUserAmq(String userAmq) {
        this.userAmq = userAmq;
    }

    private String getPasswAmq() {
        return passwAmq;
    }

    private void setPasswAmq(String passwAmq) {
        this.passwAmq = passwAmq;
    }

}