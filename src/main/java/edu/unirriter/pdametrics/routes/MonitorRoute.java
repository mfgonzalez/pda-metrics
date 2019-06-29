package edu.unirriter.pdametrics.routes;

import org.apache.activemq.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;


@Component
public class MonitorRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("{{route.from.metric}}")
                .log("Mensagem recebida")
                .unmarshal().json(JsonLibrary.Gson, Message.class)
                .bean(MessageProcessor.class, "processMessage");
    }
}
