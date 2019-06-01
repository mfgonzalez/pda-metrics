package edu.unirriter.pdametrics.routes;

public class CamelRouteBuilder implements RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start").to("direct:end");
    }
}
