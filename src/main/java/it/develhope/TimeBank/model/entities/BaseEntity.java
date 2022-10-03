package it.develhope.TimeBank.model.entities;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




    // @ManyToOne
    // private User createdBy;

    // @ManyToOne
    // private User updatedBy;
}
