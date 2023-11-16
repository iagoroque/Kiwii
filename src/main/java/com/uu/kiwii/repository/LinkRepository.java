package com.uu.kiwii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uu.kiwii.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    @Override
    List<Link> findAll();

    @Modifying
    @Query(value = "INSERT INTO link (url, rm_id, subject_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void save(String url, String rm, String subject);

}
