package com.cerberobeta.StoreWize.entities.session;

public class RequestSessionEntity {

    private SessionEntity session;

    private DetailsSessionEntity details;

    public SessionEntity getSession() {
        return session;
    }

    public void setSession(SessionEntity session) {
        this.session = session;
    }

    public DetailsSessionEntity getDetails() {
        return details;
    }

    public void setDetails(DetailsSessionEntity details) {
        this.details = details;
    }
}
