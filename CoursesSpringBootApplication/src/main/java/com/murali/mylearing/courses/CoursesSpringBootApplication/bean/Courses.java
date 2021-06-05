package com.murali.mylearing.courses.CoursesSpringBootApplication.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Courses {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String author;
	
	public Courses() {
	}
	 
	public Courses(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}


	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public String getAuthor() {
		return author;
	}


	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	
	

}
