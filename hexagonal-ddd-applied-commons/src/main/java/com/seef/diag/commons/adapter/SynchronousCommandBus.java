package com.seef.diag.commons.adapter;


import com.seef.diag.commons.CommandBus;
import com.seef.diag.commons.CommandHandler;
import com.seef.diag.commons.CommandResponse;
import com.seef.diag.commons.DomainCommand;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class SynchronousCommandBus implements CommandBus {

    private final Map<String, CommandHandler> handlersMap = new HashMap<>();

    @Inject
    public SynchronousCommandBus(List<CommandHandler<? extends DomainCommand>> handlersList) {
        if(handlersList != null) {
            handlersList.forEach(this::registerHandler);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void registerHandler(CommandHandler<? extends DomainCommand> handler) {
        handlersMap.put(handler.handles().getName(), handler);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CommandResponse push(DomainCommand command) {
        if(!handlersExistsFor(command.getClass().getName())){
            return CommandResponse.failResponse().forCommand(command).withMessage("Command handler not found for ["+command.getClass().getName()+"]");
        }
        return handlersMap.get(command.getClass().getName()).handle(command).forCommand(command);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void pushAndForget(DomainCommand command) {
        if(handlersExistsFor(command.getClass().getName())){
            handlersMap.get(command.getClass().getName()).handle(command);
        }
    }

    private boolean handlersExistsFor(String handles) {
        return this.handlersMap.containsKey(handles) && this.handlersMap.get(handles)!=null;
    }

}
