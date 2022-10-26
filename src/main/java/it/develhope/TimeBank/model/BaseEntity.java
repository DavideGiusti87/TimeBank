package it.develhope.TimeBank.model;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseEntity() {
        this.createdAt = LocalDateTime.now();
    }



    // @ManyToOne
    // private User createdBy;

    // @ManyToOne
    // private User updatedBy;
}
