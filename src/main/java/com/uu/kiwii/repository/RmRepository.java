package com.uu.kiwii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uu.kiwii.model.Rm;

@Repository
public interface RmRepository extends JpaRepository<Rm, Long> {

    @Query(value = "SELECT EXISTS(SELECT 1 FROM rm WHERE id = ?1)", nativeQuery = true)
    boolean verifyRm(String id);
}

