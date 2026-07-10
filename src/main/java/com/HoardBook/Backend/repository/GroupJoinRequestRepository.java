package com.HoardBook.Backend.repository;

import com.HoardBook.Backend.entity.GroupJoinRequest;
import com.HoardBook.Backend.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupJoinRequestRepository extends JpaRepository<GroupJoinRequest,Long> {

    //SQL : SELECT * FROM group_join_requests WHERE group_id = groupId AND request_status = status

    //WHY : Lists the join requests of a specific group where the status is PENDING
    List<GroupJoinRequest> findByGroup_IdAndStatus(Long groupId, RequestStatus status);


    //SQL : SELECT * FROM group_join_requests WHERE group_id = groupId AND group_join_request_id = requestId

    // WHY : finds the specific join request belongs to the given group
    Optional<GroupJoinRequest> findByGroup_IdAndGroupJoinRequest_Id(Long groupId, Long requestId);


}
