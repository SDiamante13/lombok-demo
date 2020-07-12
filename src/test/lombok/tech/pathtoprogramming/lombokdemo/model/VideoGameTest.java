package tech.pathtoprogramming.lombokdemo.model;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import lombok.SneakyThrows;

public class VideoGameTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private VideoGame videoGame = VideoGame.builder()
			.id(1L)
			.title("Mega Man V")
			.console("Game Boy")
			.releaseDate(LocalDate.of(1994, 7, 22))
			.genre("Platform Game")
			.build();
	
	private VideoGame videoGame2 = VideoGame.builder()
			.id(1L)
			.title("Mega Man V")
			.console("Game Boy")
			.releaseDate(LocalDate.of(1994, 7, 22))
			.genre("Platform Game")
			.build();

	@Test
	public void getGenre_returnsTheGenreOfTheVideoGame() {
		assertEquals("Platform Game", videoGame.getGenre());
	}
	
	@Test
	public void videoGameHasAnOverridenEqualsAndHashCode() {
		assertEquals(videoGame2, videoGame);
	}
	
	@Test
	public void videoGameHasAnOverridenToString() {
		assertEquals("VideoGame(id=1, title=Mega Man V, releaseDate=1994-07-22, genre=Platform Game, console=Game Boy)", videoGame.toString());
	}
	
	@Test
	public void toBuilderAndBuild_createsANewObjectWithTheNewFieldsThatWereGiven() {
		VideoGame newVideoGame = videoGame2.toBuilder().title("Metroid").releaseDate(LocalDate.of(1986, 8, 6)).build();
		assertEquals("Mega Man V", videoGame2.getTitle());
		assertEquals("Metroid", newVideoGame.getTitle());
	}
	
	@Test
	public void videoGameBuilderThrowsNullPointerException_whenTitleIsNull() {
		expectedException.expect(NullPointerException.class);
		expectedException.expectMessage("title is marked non-null but is null");
		VideoGame emptyVideoGame = VideoGame.builder().build();
	}
	
	@Test
	@SneakyThrows(UnsupportedEncodingException.class)
	public void sneakyThrowsTricksTheCompilerAndAvoidsAThrowClauseForCheckedExceptions() {
		String b = new String("hahaha".getBytes(), "UTF-8");
	}
}
