package com.jcrochavera.boundary;

import com.jcrochavera.control.GreetingService;
import com.jcrochavera.entity.Message;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by julio.rocha on 28/11/19.
 *
 * @author julio.rocha
 */
@Path("greeting")
@Produces(MediaType.TEXT_PLAIN)
public class GreetingResource {
    @Inject
    GreetingService service;

    @GET
    public String greeting() {
        return "Hello from Micro, JUGBOL!!!";
    }

    @GET
    @Path("/user-name")
    public String greetingUserName() {
        return "Hello from Micro <" + service.getUserName() + ">!!!";
    }

    @POST
    @Path("custom-message")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Retrieve the descriptions of all the products")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "successful response"),
            @APIResponse(responseCode = "400", description = "invalid query, a parameter is missing or incorrect"),
    })
    @Tag(ref = "Greeting")
    public String greetingPayload(Message message) {
        return message.message;
    }

    @GET
    @Path("fault-tolerant")
    public String greetingFaultTolerant() {
        return service.getGreetingFaultTolerant();
    }
}
