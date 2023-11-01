package com.uu.kiwii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uu.kiwii.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String>{
    
}
