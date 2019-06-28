package edu.unirriter.pdametrics.routes;


@Component
public class CamelRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start").to("direct:end");
    }
}
