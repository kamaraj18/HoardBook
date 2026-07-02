package com.HoardBook.Backend.entity;

import com.HoardBook.Backend.enums.CollectionDay;
import com.HoardBook.Backend.enums.Frequency;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "`groups`")
@Data
public class Group {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @JoinColumn( name = "current_admin_id", nullable = false)
    @ManyToOne
    private User currentAdmin;

    @Column( name = "default_amount", nullable = false)
    private BigDecimal defaultAmount;

    @Column(name = "frequency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(name = "collection_day", nullable = false)
    @Enumerated(EnumType.STRING)
    private CollectionDay collectionDay;

    @Column( name = "is_active")
    private boolean isActive = true;

    @Column( name = "deleted_at", nullable =true)
    private LocalDateTime deletedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column( name="invite_code", unique = true, nullable = false)
    private String inviteCode;
}
