package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.border.EtchedBorder;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestGetStudentById_Courses {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student student = entityManager.find(Student.class, 6);
		if (student != null) {
			System.out.println("Student name: " + student.getName());
			System.out.println("Age: " + student.getAge());
			System.out.println("------------------------------------");

			List<Course> courses = student.getCourses();
			if (courses != null) {
				for (Course course : courses) {
					System.out.println("Course ID: " + course.getId());
					System.out.println("Course name: " + course.getName());
					System.out.println("Course duration: " + course.getDuration());
					System.out.println("-----------");
				}
			} else {
				System.out.println("Student yet to take the course");
			}
		} else {
			System.out.println("No such student id");
		}
	}
}
