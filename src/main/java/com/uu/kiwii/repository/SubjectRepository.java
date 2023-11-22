package com.uu.kiwii.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uu.kiwii.model.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, String>{

    @Override
    Optional<Subject> findById(String id);

    @Query(value = "SELECT * FROM subject ORDER BY name ASC", nativeQuery = true)
    List<Subject> findAll();

    @Query(value = "SELECT EXISTS(SELECT 1 FROM subject WHERE id = ?1)", nativeQuery = true)
    boolean verifySubject(String code);

}
