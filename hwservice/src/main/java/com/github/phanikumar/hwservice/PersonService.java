/**
 * 
 */
package com.github.phanikumar.hwservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.github.phanikumar.hwservice.model.Person;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

/**
 * @author phani kumar
 *
 */
@Slf4j
@Component
public class PersonService {

	private static final List<Person> persons = Arrays.asList(new Person("Jon", "Doe"), 
			new Person("Phani", "Bhamidipati"),
			new Person("David", "Smith"));
	
	private final Counter counter;
	
	public PersonService(MeterRegistry registry) {
		this.counter = registry.counter("person.counter");
	}
	
	public List<Person> getAllPersons() {
		log.info("Getting persons...");
		counter.increment();
		return persons;
	}
	
	@Timed(value = "update.person", longTask = true, extraTags = {"region", "asia"})
	public void updatePerson() {
		log.info("Updating person");
		try {
			Thread.sleep(60000);
		}catch(Exception e){
			log.error("Boom. exception:" + e);
		}
		log.info("update successfull");
	}
	
	
	public void updatePerson_fail() {
		log.info("calling update...");
		throw new RuntimeException("Something terrible happend....");
	}
}
