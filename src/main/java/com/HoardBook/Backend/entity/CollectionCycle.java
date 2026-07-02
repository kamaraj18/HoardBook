package com.HoardBook.Backend.entity;

import com.HoardBook.Backend.enums.CycleStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table( name = "collection_cycles")
@Data
public class CollectionCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cycle_id")
    private Long id;

    @JoinColumn(name = "group_id", nullable = false)
    @ManyToOne //One Group has MANY cycles.
    private Group group;

    @Column( name = "cycle_number", nullable = false )
    private int cycleNumber;

    @Column( name = "cycle_date", nullable = false)
    private LocalDate cycleDate;

    @Column( name = "cycle_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CycleStatus cycleStatus = CycleStatus.OPEN;

    @CreationTimestamp
    @Column( name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
