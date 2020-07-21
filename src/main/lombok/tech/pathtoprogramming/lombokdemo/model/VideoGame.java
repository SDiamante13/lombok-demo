package tech.pathtoprogramming.lombokdemo.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.With;
import lombok.extern.slf4j.Slf4j;

@Builder(toBuilder = true)
@Value
@With
@Slf4j
public class VideoGame {
	long id;
	@NonNull
	String title;
	LocalDate releaseDate;
	@With
	String genre;
	String console;
	
	public void printLogMessage() {
		log.info("Video games are fun!");
	}
}
