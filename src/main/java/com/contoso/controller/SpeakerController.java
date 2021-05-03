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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class SpeakerController {

    @Inject
    public ServerStatService serverStatService;

    @Inject
    private MongoClient mongoClient;

    @GET
    @Path("speakers")
    public FindIterable<Document> getAllSpeakers() {
        serverStatService.speakersPageHadBeenVisit();
        MongoCollection<Document> speakerCollection = mongoClient.getDatabase(DBDatabase.CONTENT_DB).getCollection(DBCollection.SPEAKERS_COLLECTION);
        return speakerCollection.find();
    }
    

}