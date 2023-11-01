package com.uu.kiwii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uu.kiwii.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT EXISTS(SELECT * FROM courses WHERE ?1 = ANY(rm))", nativeQuery = true)
    boolean findRmOnCourse(String rm);
    
}
