package com.HoardBook.Backend.repository;

import com.HoardBook.Backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


    //SQL : SELECT * FROM payments WHERE group_id = groupId AND cycle_id = cycleId
    //WHY : list the payments of specific cycle of an group
    //API endpoint : GET /api/groups/{groupId}/collection-cycles/{cycleId}/payments
    List<Payment> findByGroup_IdAndCycle_Id(Long groupId, Long cycleId);

    //API endpoint : PATCH /api/groups/{groupId}/collection-cycles/{cycleId}/payments/{paymentId}/mark-paid
    //API endpoint : PATCH /api/groups/{groupId}/collection-cycles/{cycleId}/payments/{paymentId}/undo
    //WHY : finds a specific payment belongs to specific cycle of an group
    //SQL : SELECT * FROM payments WHERE group_id = groupId AND cycle_id = cycleId AND payment_id = PaymentId
    Optional<Payment> findByGroup_IdAndCycle_IdAndPayment_Id(Long groupId, Long cycleId, Long paymentId);

}
