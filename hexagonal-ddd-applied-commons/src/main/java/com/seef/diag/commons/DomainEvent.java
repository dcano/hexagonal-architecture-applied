package com.seef.diag.commons;

import java.time.ZonedDateTime;

public abstract class DomainEvent {

    /**
     * When the event was created in UIC
     */
    private final ZonedDateTime occurredOn;

    /**
     * Randomly generated UID for created events
     */
    private final String eventUid;

    /**
     * TenandId for the domain event
     */
    private final String tenantId;

    public DomainEvent(ZonedDateTime occurredOn, String eventUid, String tenantId) {
        this.occurredOn = occurredOn;
        this.eventUid = eventUid;
        this.tenantId = tenantId;
    }

    public ZonedDateTime getOccurredOn() {
        return occurredOn;
    }

    public String getEventUid() {
        return eventUid;
    }

    public String getTenantId() {
        return tenantId;
    }

}
