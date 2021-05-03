package com.contoso.model;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Counter {

    private int stats;

    private int speakers;

    private int sessions;

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public int getSpeakers() {
        return speakers;
    }

    public void setSpeakers(int speakers) {
        this.speakers = speakers;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    public void sessionsPageHadBeenVisit() {
        this.sessions++;
    }

    public void speakersPageHadBeenVisit() {
        this.speakers++;
    }

    public void statsPageHadBeenVisit() {
        this.stats++;
    }

    @Override
    public String toString() {
        return "ServerStat [sessions=" + sessions + ", speakers=" + speakers + ", stats=" + stats + "]";
    }

}
