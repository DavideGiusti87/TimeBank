package it.develhope.TimeBank.utils;

import it.develhope.TimeBank.model.entities.User;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @ManyToOne
    private User createdBy;
    @ManyToOne
    private User updatedBy;
}
