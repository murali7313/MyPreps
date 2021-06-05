package com.murali.mylearing.courses.CoursesSpringBootApplication.exceptions;

public class NoCourseFoundException extends RuntimeException {
	
	
	public NoCourseFoundException(String message) {
		super(message);
	}
}
