package com.seef.diag.commons;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class DomainCommand {

    protected final String commandUid;
    protected final ZonedDateTime occurredOn;
    protected final String tenantId;

    public DomainCommand(String tenantId) {
        occurredOn = ZonedDateTime.now(ZoneOffset.UTC);
        commandUid = UUID.randomUUID().toString();
        this.tenantId = tenantId;
    }

    public String commandUid() {
        return commandUid;
    }

    public ZonedDateTime occurredOn() {
        return occurredOn;
    }

    public String commandName() {
        return this.getClass().getName();
    }

    public String tenantId() {
        return tenantId;
    }

}
