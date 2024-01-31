package software.nectar.java.models;

import java.time.Instant;

public class Subscriber {

    private String name;

    private String phoneNo;

    private String ref;

    private boolean activated;

    private Instant createdAt;

    private Instant updatedAt;

    public Subscriber(String name, String phoneNo, String ref,
                      boolean activated, Instant createdAt, Instant updatedAt) {
        setName(name);
        setPhoneNo(phoneNo);
        setRef(ref);
        setActivated(activated);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
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
        return String.format("Subscriber { name: %s, phone_no: %s, ref: %s, " +
                        "activated: %s:, updated_at: %b, created_at: %s }\n",
                name, phoneNo, ref, activated, updatedAt.toString(), createdAt.toString());
    }
}
