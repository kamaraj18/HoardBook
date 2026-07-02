package com.HoardBook.Backend.entity;

import com.HoardBook.Backend.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @JoinColumn(name = "cycle_id", nullable = false)
    @ManyToOne
    private CollectionCycle cycle;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne
    private User member;

    @Column( name = "expected_amount", nullable = false)
    private BigDecimal expectedAmount;

    @Column( name = "amount_paid")
    private BigDecimal amountPaid;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;

    @Column(name= "paid_at")
    private LocalDateTime paidAt;

    @ManyToOne
    @JoinColumn(name = "recorded_by")
    private User recordedBy;

    @Column( name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @ManyToOne
    @JoinColumn(name="last_modified_by")
    private User lastModifiedBy;


}
