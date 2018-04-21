package com.seef.diag.commons;


import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Created by canod on 18/07/2017.
 */

public final class TenantId extends ValueObject {

    @NotNull(message = "lblNotNullId")
    private final String id;

    private TenantId(String id) {
        this.id = id;
        this.validate();
    }

    public static TenantId of(String id) {
        if(id == null) {
            return null;
        }
        return new TenantId(id);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TenantId tenantId = (TenantId) o;
        return Objects.equals(getId(), tenantId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TenantId{" +
                "id='" + id + '\'' +
                '}';
    }
}
