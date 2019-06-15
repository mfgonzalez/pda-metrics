package edu.unirriter.pdametrics.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouteBuilder implements RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start").to("direct:end");
    }
}
