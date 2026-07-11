package com.HoardBook.Backend.repository;

import com.HoardBook.Backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


    //SQL : SELECT * FROM payments WHERE group_id = groupId AND cycle_id = cycleId
    //WHY : list the payments of specific cycle of an group
    //API endpoint : GET /api/groups/{groupId}/collection-cycles/{cycleId}/payments
    @Query("SELECT p FROM Payment p " +
            "WHERE p.cycle.id = :cycleId " +
            "AND p.cycle.group.id = :groupId")
    List<Payment> findByCycleIdAndGroupId(
            @Param("cycleId") Long cycleId,
            @Param("groupId") Long groupId);

    //API endpoint : PATCH /api/groups/{groupId}/collection-cycles/{cycleId}/payments/{paymentId}/mark-paid
    //API endpoint : PATCH /api/groups/{groupId}/collection-cycles/{cycleId}/payments/{paymentId}/undo
    //WHY : finds a specific payment belongs to specific cycle of an group
    //SQL : SELECT * FROM payments WHERE group_id = groupId AND cycle_id = cycleId AND payment_id = PaymentId
    @Query("SELECT p FROM Payment p " +
            "WHERE p.id = :paymentId " +
            "AND p.cycle.group.id = :groupId " +
            "AND p.cycle.id = :cycleId")
    Optional<Payment> findByIdAndGroup_IdAndCycle_Id( @Param("paymentId")Long paymentId, @Param("groupId")Long groupId, @Param("cycleId")Long cycleId);

    // WHY: Prevent duplicate payment records per member per cycle
    boolean existsByCycle_IdAndMember_Id(Long cycleId, Long memberId);
}
