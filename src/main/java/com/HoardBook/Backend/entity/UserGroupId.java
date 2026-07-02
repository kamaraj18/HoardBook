package com.HoardBook.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable                        //marks the class as embeddable inside an entity
@EqualsAndHashCode
@Data
public class UserGroupId implements Serializable {         // to use composite key we create this entity to serve this as primary key of this table.

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "group_id")
    private Long groupId;
}
