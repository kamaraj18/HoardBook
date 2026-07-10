package com.HoardBook.Backend.repository;

import com.HoardBook.Backend.entity.CollectionCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollectionCycleRepository extends JpaRepository<CollectionCycle, Long> {

    //API endpoint - GET /api/groups/{groupId}/collection-cycles
    //SQL : SELECT * FROM CollectionCycle WHERE group_id = groupId;
    //WHY : Fetches Collection cycle records belongs to specific group
    List<CollectionCycle> findByGroup_Id(Long groupId);

    //SQL : SELECT * FROM CollectionCycle WHERE group_id = groupId AND cycle_id = cycleId;
    //WHY : Fetches Collection cycle records belongs to specific group
    //API endpoint - GET /api/groups/{groupId}/collection-cycles/{cycleId}
    Optional<CollectionCycle> findByGroup_IdAndCycle_Id(Long groupId, Long cycleId);



}
