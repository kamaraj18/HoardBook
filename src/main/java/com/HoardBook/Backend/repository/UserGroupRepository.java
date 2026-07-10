package com.HoardBook.Backend.repository;


import com.HoardBook.Backend.entity.UserGroup;
import com.HoardBook.Backend.entity.UserGroupId;
import com.HoardBook.Backend.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, UserGroupId> {

   List<UserGroup> findByGroup_IdAndStatus(Long groupId, Status status);

   Optional<UserGroup> findByGroup_IdAndUser_Id(Long groupId, Long userId);

    boolean existsByGroup_IdAndUser_Id(Long groupId, Long userId);

}
