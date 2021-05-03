package com.contoso.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.contoso.model.Counter;
import com.contoso.model.Stats;
import com.contoso.service.ServerStatService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class ServerStatController {

    @Inject
    public ServerStatService serverStatService;

    @Path("stats")
    @GET
    public Stats showApplicationStats() {
        return serverStatService.showServerStats();
    }

}
