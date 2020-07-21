package tech.pathtoprogramming.lombokdemo.model;

import lombok.AllArgsConstructor;
import lombok.With; 

@AllArgsConstructor
@With
public class Address {
	private String city;
	private String state;
	private String streetAddress;
	private String zipcode;
}
