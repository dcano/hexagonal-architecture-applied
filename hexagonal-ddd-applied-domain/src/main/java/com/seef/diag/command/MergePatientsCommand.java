package com.seef.diag.command;

import com.seef.diag.commons.DomainCommand;

public class MergePatientsCommand extends DomainCommand {

    private final String sourcePatientId;
    private final String destinationPatientId;

    public MergePatientsCommand(String sourcePatientId, String destinationPatientId, String tenantId) {
        super(tenantId);
        this.sourcePatientId = sourcePatientId;
        this.destinationPatientId = destinationPatientId;
    }

    public String getSourcePatientId() {
        return sourcePatientId;
    }

    public String getDestinationPatientId() {
        return destinationPatientId;
    }
}
