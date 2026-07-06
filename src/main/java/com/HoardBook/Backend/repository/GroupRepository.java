package com.HoardBook.Backend.repository;

import com.HoardBook.Backend.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    //WHY: checks the group with specific invite code exists if yes, return true otherwise false
    boolean existsByInviteCode(String inviteCode);

    //WHY: gives the groups belongs to specific user
    @Query("SELECT g FROM Group g JOIN UserGroup ug ON ug.group = g WHERE ug.user.id = :userId AND ug.status = 'ACTIVE' AND g.isActive = true")
    List<Group> findAllGroupsByUserId(@Param("userId") Long userId);
}
