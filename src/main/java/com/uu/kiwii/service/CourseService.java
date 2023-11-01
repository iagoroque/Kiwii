package com.uu.kiwii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uu.kiwii.model.Course;
import com.uu.kiwii.repository.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    public void save(Course course) {
        courseRepository.save(course);
    }

    public boolean findRmOnCourse(String rm) {
        return courseRepository.findRmOnCourse(rm);
    }
}
