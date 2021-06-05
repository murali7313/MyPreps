package com.murali.mylearing.courses.CoursesSpringBootApplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.murali.mylearing.courses.CoursesSpringBootApplication.bean.Courses;
import com.murali.mylearing.courses.CoursesSpringBootApplication.exceptions.NoCourseFoundException;
import com.murali.mylearing.courses.CoursesSpringBootApplication.repository.CoursesRepository;

@RestController
public class CoursesController {
	
	@Autowired
	private CoursesRepository repository;
	
	
	//HTTP GET METHOD:
	@GetMapping("/courses")
	public List<Courses> getAllCourses(){
		return repository.findAll();
	}
	
	//HTTP GET METHOD:
	@GetMapping("/courses/{id}")
	public Courses addNewCourses(@PathVariable long id){
		
		
		Optional<Courses> returnCourse = repository.findById(id);
		
		if(returnCourse.isEmpty()) {
			throw new NoCourseFoundException("There is not Course with the id "+ id);
		}
		
		return returnCourse.get();
		
	}
	
	//HTTP POST METHOD:
	@PostMapping("/addcourses")
	public ResponseEntity<List<Courses>> addCourseToRepository(@RequestBody Courses courses) {
		repository.save(courses);
		List<Courses> course1 = new ArrayList<>();
		course1 = repository.findAll();
		return new ResponseEntity<>(course1,HttpStatus.OK);
	}

	//HTTP DELETE METHOD:
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Courses> deleteCourse(@PathVariable long id) {
		Optional<Courses> returnCourse = repository.findById(id);

		if (returnCourse.isEmpty()) {
			throw new NoCourseFoundException("There is not Course with the id " + id);
		}else {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

}
