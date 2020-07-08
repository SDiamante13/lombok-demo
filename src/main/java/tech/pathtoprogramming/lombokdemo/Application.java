package tech.pathtoprogramming.lombokdemo;

import java.time.LocalDate;

import tech.pathtoprogramming.lombokdemo.model.VideoGame;

public class Application {

	public static void main(String[] args) {
		VideoGame videoGame = VideoGame.builder()
				.id(1L)
				.title("Mega Man V")
				.console("Game Boy")
				.releaseDate(LocalDate.of(1994, 7, 22))
				.genre("Platform Game")
				.build();
		
		VideoGame videoGame2 = VideoGame.builder()
				.id(1L)
				.title("Mega Man V")
				.console("Game Boy")
				.releaseDate(LocalDate.of(1994, 7, 22))
				.genre("Platform Game")
				.build();
		
		System.out.println("Video game: " + videoGame);
		System.out.println("Are these games equal: " + videoGame.equals(videoGame2));
		System.out.println("Getter works, getting title: " + videoGame.getTitle());
		videoGame.setGenre("Sega");
		System.out.println("Setter works, changing genre: " + videoGame.getGenre());
		
		System.out.println("Creating new object using toBuilder method " + videoGame2.toBuilder().title("Metroid").releaseDate(LocalDate.of(1986, 8, 6)).build());
		System.out.println("Are these games equal: " + videoGame.equals(videoGame2));
		

	}

}
