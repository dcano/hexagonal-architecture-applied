package com.seef.diag.commons;

/**
 * Created by David on 19/03/2017.
 */

public final class CommandResponse {

    private DomainCommand sourceCommand;
    private boolean success;
    private String message;
    private Object response;
    private int errorCode;

    private CommandResponse(boolean success, Object response){
        this.success = success;
        this.response = response;
    }

    public static CommandResponse sucessResponse(Object response) {
        return new CommandResponse(true, response);
    }

    public static CommandResponse failResponse(Object response) {
        return new CommandResponse(false, response);
    }

    public static CommandResponse failResponse(){
        return CommandResponse.failResponse(null);
    }


    public CommandResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public CommandResponse withErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public CommandResponse forCommand(DomainCommand command) {
        this.sourceCommand = command;
        return this;
    }

    public CommandResponse build(){
        return this;
    }

    public String getCommandUid() {
        return sourceCommand.commandUid();
    }

    public DomainCommand getSourceCommand() {
        return sourceCommand;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getResponse() {
        return response;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
