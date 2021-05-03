package com.contoso.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.contoso.model.Counter;
import com.contoso.model.Stats;
import com.mongodb.internal.connection.Server;

@ApplicationScoped
public class ServerStatService {

    @Inject
    private Counter serverCounter;

    @Inject
    private Stats serverStat;


    public void sessionPageHadBeenvisited(){
        this.serverCounter.sessionsPageHadBeenVisit();
    }

    public void speakersPageHadBeenVisit(){
        this.serverCounter.speakersPageHadBeenVisit();
    }

    public Stats showServerStats(){
        return this.serverStat;
    }

}
