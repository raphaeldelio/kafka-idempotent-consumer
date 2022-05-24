package demo.kafka.domain;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

@Entity(name="ProcessedEvent")
public class ProcessedEvent implements Serializable, Persistable<UUID> {

    @Id
    @Column(name="eventid")
    private UUID eventId;

    public ProcessedEvent(){}

    public ProcessedEvent(final UUID eventId) {
        this.eventId = eventId;
    }

    @Transient
    @Override
    public UUID getId() {
        return eventId;
    }

    /**
     * Ensures Hibernate always does an INSERT operation when save() is called.
     */
    @Transient
    @Override
    public boolean isNew() {
        return true;
    }
}
