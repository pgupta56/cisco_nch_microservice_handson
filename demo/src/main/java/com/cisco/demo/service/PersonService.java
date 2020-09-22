package com.cisco.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.demo.model.Person;
import com.cisco.demo.repository.PersonRepository;

@Service
public class PersonService {
   
	@Autowired
	private PersonRepository personRepository;
	
	//1.Create operation
	public Person create(String firstName,String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
	}

	//2.Retrieve operation
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}

	//3.Update operation
	public Person update(String firstName, String lastName, int age) {
		Person p = personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}

	//4.Delete all operation
	public void deleteAll() {
		personRepository.deleteAll();
	}

	//5.Delete a  Specific Person
	public void delete(String firstName) {
		Person p = personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
}
