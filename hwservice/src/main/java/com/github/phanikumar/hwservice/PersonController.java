/**
 * 
 */
package com.github.phanikumar.hwservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.phanikumar.hwservice.model.Person;

import io.micrometer.core.annotation.Timed;

/**
 * @author phani kumar
 *
 */
@RestController
@RequestMapping(path = "/person")
@Timed
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping(path = "/")
	public List<Person> getPersons(){
		return personService.getAllPersons();
	}
	
	@GetMapping(path = "/update")
	public void updatePerson() {
		personService.updatePerson();
	}
	
	@GetMapping("/fail")
	public void failPerson() {
		personService.updatePerson_fail();
	}
}
