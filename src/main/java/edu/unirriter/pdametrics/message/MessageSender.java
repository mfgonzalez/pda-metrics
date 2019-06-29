package edu.unirriter.pdametrics.message;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class MessageSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("{{route.to.alert}}") //parte anterior da rota
                .marshal().json(JsonLibrary.Gson, true)
                .log("enviando alerta")
                .to("{{route.to.alert}}");
    }

}
