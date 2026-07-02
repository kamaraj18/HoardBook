package com.HoardBook.Backend.entity;

import com.HoardBook.Backend.enums.Role;
import com.HoardBook.Backend.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Table(name= "user_groups")
@Entity
@Data
public class UserGroup {

    @EmbeddedId
    private UserGroupId id;

    @ManyToOne
    @MapsId("userId") // maps the FK field "userId" to corresponding Id "user" field.
    @JoinColumn(name = "user_id", nullable = false) //@JoinColumn - creates the user_id(FK) column in this table
    private User user;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

    @Column(name = "joined_at", nullable = false, updatable = false)
    @CurrentTimestamp
    private LocalDateTime joinedAt;

    @Column(name = "removed_at")
    private LocalDateTime removedAt;

    @ManyToOne
    @JoinColumn(name = "removed_by")
    private User removedBy;

}
