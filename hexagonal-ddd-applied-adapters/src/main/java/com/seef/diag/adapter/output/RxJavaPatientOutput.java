package com.seef.diag.adapter.output;

import com.seef.diag.commons.DomainCommand;
import com.seef.diag.domain.model.Patient;
import com.seef.diag.domain.port.PatientOutputPort;

import javax.inject.Named;
import java.util.List;

@Named
public class RxJavaPatientOutput implements PatientOutputPort {

    //TODO
    //In controllers create command callbacks that will be registered DI in the output adapter in an observable
    //Also mappers from domain object to the view representation or DPO will be registered by DI
    //Extend interface of patient output port to register listeners??

    @Override
    public void write(Patient patient, DomainCommand domainCommand) {

    }

    @Override
    public void write(List<Patient> patients) {

    }
}
