package com.seef.diag.commons;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class DomainCommand {

    protected final String commandUid;
    protected final ZonedDateTime occurredOn;
    protected final String tenantId;
    private final DomainUser userInfo;
    private final String version;

    public DomainCommand(String tenantId, DomainUser userInfo, String version) {
        occurredOn = ZonedDateTime.now(ZoneOffset.UTC);
        commandUid = UUID.randomUUID().toString();
        this.tenantId = tenantId;
        this.userInfo = userInfo;
        this.version = version;
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

    public DomainUser getUserInfo() {
        return userInfo;
    }

    public String version() {
        return version;
    }

}
