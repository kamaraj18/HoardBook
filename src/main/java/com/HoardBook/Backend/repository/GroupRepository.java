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

    @Query("SELECT ug.group FROM UserGroup ug WHERE ug.user.id = :userId AND ug.status = 'ACTIVE' AND ug.group.isActive = true")
    List<Group> findAllGroupsByUserId(@Param("userId") Long userId);
}
