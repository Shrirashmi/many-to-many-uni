package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Person;
import com.ty.manytomany.dto.Cab;

public class TestSaveCabs_Person {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Cab cab = new Cab();
		cab.setDriverName("rohit");
		cab.setCost(100);
		List<Person> person = new ArrayList<Person>();
		Person person1 = entityManager.find(Person.class, 3);
		Person person2 = entityManager.find(Person.class, 2);
		person.add(person1);
		person.add(person2);
		
		cab.setPersons(person);
		entityTransaction.begin();
		entityManager.persist(cab);
		entityTransaction.commit();
	}
}
