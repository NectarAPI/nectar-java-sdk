package software.nectar.java.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    private String name;

    private String ref;

    private String contactPhoneNo;

    private double unitCharge;

    private Boolean activated;

    private String configRef;

    private List<Meter> meters;

    private Instant createdAt;

    private Instant updatedAt;

    public  Utility(String name, String ref, String contactPhoneNo,
                   double unitCharge, boolean activated, String configRef,
                   List<Meter> meters, Instant createdAt, Instant updatedAt) {
        setName(name);
        setRef(ref);
        setContactPhoneNo(contactPhoneNo);
        setUnitCharge(unitCharge);
        setActivated(activated);
        setConfigRef(configRef);
        setMeters(meters);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    private void setRef(String ref) {
        this.ref = ref;
    }

    public String getContactPhoneNo() {
        return contactPhoneNo;
    }

    public void setContactPhoneNo(String contactPhoneNo) {
        this.contactPhoneNo = contactPhoneNo;
    }

    public double getUnitCharge() {
        return unitCharge;
    }

    public void setUnitCharge(double unitCharge) {
        this.unitCharge = unitCharge;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getConfigRef() {
        return configRef;
    }

    public void setConfigRef(String configRef) {
        this.configRef = configRef;
    }

    public List<Meter> getMeters() {
        return meters;
    }

    public void setMeters(List<Meter> meters) {
        this.meters = meters;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format("Utility { name: %s, ref: %s, contact_phone_no: %s, " +
                        "unit_charge: %s, activated: %s:, config_ref: %s, " +
                        "meters: %s, updated_at: %b, created_at: %s }\n",
                name, ref, contactPhoneNo, unitCharge, activated,
                configRef, meters, updatedAt.toString(), createdAt.toString());
    }
}
