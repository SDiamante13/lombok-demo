package tech.pathtoprogramming.lombokdemo.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public void savePerson(Person person) {
		personRepository.save(person);
	}
}
