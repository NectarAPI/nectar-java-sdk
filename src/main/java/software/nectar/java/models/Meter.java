package software.nectar.java.models;

import java.math.BigDecimal;
import java.time.Instant;

public class Meter {
    private BigDecimal no;

    private Boolean activated;

    private MeterType meterType;

    private Subscriber subscriber;

    private String ref;

    private Instant createdAt;

    private Instant updatedAt;

    public Meter(String ref, BigDecimal no, boolean activated,
                 MeterType meterType, Subscriber subscriber,
                 Instant createdAt, Instant updatedAt) {
        setNo(no);
        setActivated(activated);
        setMeterType(meterType);
        setSubscriber(subscriber);
        setRef(ref);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public MeterType getMeterType() {
        return meterType;
    }

    public void setMeterType(MeterType meterType) {
        this.meterType = meterType;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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
        return String.format("Meter { no: %s, activated: %s, meter_type: %s, " +
                        "subscriber: %s, ref: %s, updated_at: %b, created_at: %s }\n",
                no, activated, meterType, subscriber, ref,
                updatedAt.toString(), createdAt.toString());
    }

}
