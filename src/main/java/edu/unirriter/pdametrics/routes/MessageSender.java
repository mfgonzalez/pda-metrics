package edu.unirriter.pdametrics.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class MessageSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("{{route.from.metric}}")
                .marshal().json(JsonLibrary.Gson, true)
                .log("enviando alerta ${body}" )
                .to("{{route.to.alert}}");
    }

}
