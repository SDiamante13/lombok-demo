package tech.pathtoprogramming.lombokdemo.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class VideoGame {
	long id;
	@NonNull
	String title;
	LocalDate releaseDate;
	String genre;
	String console;
}
