package com.HoardBook.Backend.repository;

import com.HoardBook.Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByGoogleId(String googleId);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u " +
            "JOIN UserGroup ug ON ug.user = u " +
            "WHERE ug.group.id = :groupId " +
            "AND ug.status = 'ACTIVE'")
    List<User> findActiveGroupMembers(@Param("groupId") Long groupId);

}
