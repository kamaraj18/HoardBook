package com.HoardBook.Backend.entity;

import com.HoardBook.Backend.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table( name = "group_join_requests")
@Data
public class GroupJoinRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_join_request_id")
    private Long id;

    @JoinColumn(name= "group_id", nullable = false)
    @ManyToOne
    private Group group;

    @JoinColumn(name = "requested_by", nullable = false)
    @ManyToOne
    private User requestedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "request_status")
    private RequestStatus requestStatus = RequestStatus.PENDING;

    @Column( name="requested_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime requestedAt;

    @Column( name="responded_at")
    private LocalDateTime respondedAt;

    @JoinColumn( name="responded_by", nullable = true)
    @ManyToOne
    private User respondedBy;
}
