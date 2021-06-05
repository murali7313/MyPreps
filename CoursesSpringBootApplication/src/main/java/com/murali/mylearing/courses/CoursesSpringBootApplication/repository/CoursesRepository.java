package com.murali.mylearing.courses.CoursesSpringBootApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murali.mylearing.courses.CoursesSpringBootApplication.bean.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
