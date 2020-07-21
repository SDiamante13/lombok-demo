package tech.pathtoprogramming.lombokdemo.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonRepository {
	
	public void save(Person person) {
		log.info("saving person");
	}
}
