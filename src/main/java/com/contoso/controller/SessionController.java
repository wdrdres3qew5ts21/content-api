package com.contoso.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.contoso.model.DBCollection;
import com.contoso.model.DBDatabase;
import com.contoso.service.ServerStatService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.jboss.logging.Logger;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class SessionController {

    @Inject
    private ServerStatService serverStatService;

    @Inject
    private MongoClient mongoClient;

    private static final Logger LOG = Logger.getLogger(SessionController.class);

    @GET
    @Path("sessions")
    public FindIterable<Document> getAllSessions() {
        serverStatService.sessionPageHadBeenvisited();
        MongoCollection<Document> sessionCollection = mongoClient.getDatabase(DBDatabase.CONTENT_DB)
                .getCollection(DBCollection.SESSIONS_COLLECTION);

        LOG.info(sessionCollection);
        return sessionCollection.find();
    }

}
