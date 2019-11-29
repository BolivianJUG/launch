package com;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 * Created by julio.rocha on 28/11/19.
 *
 * @author julio.rocha
 */
@OpenAPIDefinition(
        tags = {
                @Tag(name = "Greeting", description = "API used to retrieve the status of tags"),
        },
        info = @Info(title = "API", version = "0.0.1", description = "This is my API description")
        ,
        security = @SecurityRequirement(name = "BasicAuth"),
        components = @Components(
                securitySchemes = @SecurityScheme(
                        securitySchemeName = "BasicAuth", scheme = "basic", type = SecuritySchemeType.HTTP
                )
        )
)
@ApplicationPath("/")
public class JAXRSConfiguration extends Application {

}
