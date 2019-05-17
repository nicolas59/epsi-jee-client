package fr.epsi.client;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

import fr.epsi.client.v1.resources.ClientResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
    this.register(ClientResource.class);
  }

  @PostConstruct
  public void init() {
    // Register components where DI is needed
    this.SwaggerConfig();
  }

  private void SwaggerConfig() {
    this.register(ClientResource.class);
    this.register(WadlResource.class);
    this.register(ApiListingResource.class);
    this.register(SwaggerSerializers.class);

    BeanConfig swaggerConfigBean = new BeanConfig();
    swaggerConfigBean.setConfigId("Swagger Client API");
    swaggerConfigBean.setTitle("Using Swagger, Jersey And Spring Boot ");
    swaggerConfigBean.setVersion("v1");
    swaggerConfigBean.setContact("Epsi");
    swaggerConfigBean.setSchemes(new String[] { "http"});
    swaggerConfigBean.setBasePath("/api");
    swaggerConfigBean.setResourcePackage("fr.epsi.client.v1.resources");
    swaggerConfigBean.setPrettyPrint(true);
    swaggerConfigBean.setScan(true);
  }
}