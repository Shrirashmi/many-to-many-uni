package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestSaveStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student = new Student();
		student.setName("ram");
		student.setAge(17);
		List<Course> courses = new ArrayList<Course>();
		Course course1 = new Course();
		course1.setName("SQL");
		course1.setDuration("1 months");
		courses.add(course1);
		
		Course course2 = new Course();
		course2.setName("React");
		course2.setDuration("4 months");
		courses.add(course2);
		student.setCourses(courses);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityTransaction.commit();
		}
}
