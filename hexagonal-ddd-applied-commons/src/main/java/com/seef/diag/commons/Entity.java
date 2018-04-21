package com.seef.diag.commons;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by canod on 18/07/2017.
 */
public abstract class Entity extends ModelValidator{
    @NotNull
    @Valid
    private final List<@NotNull DomainEvent> events;
    @PositiveOrZero
    private long version;

    public Entity() {
        this.events = new ArrayList<>();
        this.validateProperty("events");
    }

    public long getVersion() {
        return version;
    }

    protected void publishEvent(DomainEvent event) {
        //this.events.add(event);
        this.events.add(event);
    }

    public boolean hasEvents(){
        return !events.isEmpty();
    }

    /**
     * Retrieve the events
     * @return
     */
    public List<DomainEvent> getDomainEvents() {
        return Collections.unmodifiableList(events);
    }

    protected void setVersion(long version) {
        this.version = version;
        this.validateProperty("version");
    }
}
