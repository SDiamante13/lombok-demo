package tech.pathtoprogramming.lombokdemo.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoGame {
	private long id;
	private String title;
	private LocalDate releaseDate;
	private String genre;
	private String console;
}
