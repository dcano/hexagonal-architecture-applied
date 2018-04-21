package com.seef.diag.commons;

/**
 * Created by canod on 18/07/2017.
 */

public interface CommandBus {
    void registerHandler(final CommandHandler<? extends DomainCommand> handler);
    CommandResponse push(final DomainCommand command);
    void pushAndForget(final DomainCommand command);
}
