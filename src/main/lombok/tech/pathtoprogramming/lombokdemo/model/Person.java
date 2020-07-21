package tech.pathtoprogramming.lombokdemo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String name;
	private int age;
	private List<Hobby> hobbies;
	private Address address;
	private Profession profession;
}