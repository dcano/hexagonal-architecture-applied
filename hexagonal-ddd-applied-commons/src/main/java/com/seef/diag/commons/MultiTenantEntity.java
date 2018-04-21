package com.seef.diag.commons;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by alonsotd on 10/10/2017.
 */

public abstract class MultiTenantEntity extends Entity {
    @NotNull(message = "lblTenantIdNotNull")
    @Valid
    private final TenantId tenantId;

    public MultiTenantEntity(TenantId tenantId) {
        this.tenantId = tenantId;
        this.validateProperty("tenantId");
    }

    public TenantId getTenantId() {
        return tenantId;
    }
}
