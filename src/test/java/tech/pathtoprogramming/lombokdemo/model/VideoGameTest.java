package tech.pathtoprogramming.lombokdemo.model;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import lombok.SneakyThrows;
import tech.pathtoprogramming.lombokdemo.LogTestUtil;

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
		assertEquals("VideoGame(id=1, title=Mega Man V, releaseDate=1994-07-22, genre=Platform Game, console=Game Boy)",
				videoGame.toString());
	}

	@Test
	public void toBuilderAndBuild_createsANewObjectWithTheNewFieldsThatWereGiven() {
		VideoGame newVideoGame = videoGame2.toBuilder().
				title("Metroid")
				.releaseDate(LocalDate.of(1986, 8, 6))
				.build();
		assertEquals("Mega Man V", videoGame2.getTitle());
		assertEquals("Metroid", newVideoGame.getTitle());
	}

	@Test
	public void WithWorks() {
		VideoGame actionVideoGame = videoGame.withGenre("Action");
		assertEquals("Action", actionVideoGame.getGenre());
	}

	@Test
	public void videoGameBuilderThrowsNullPointerException_whenTitleIsNull() {
		expectedException.expect(NullPointerException.class);
		expectedException.expectMessage("title is marked non-null but is null");
		VideoGame emptyVideoGame = VideoGame.builder().build();
	}

	@Test
	public void with_returnsNewObjectWithNewFieldNamePresent_canBeChained() {
		VideoGame videoGame3 = videoGame2.withConsole("Sega").withGenre("Action");
		assertEquals("Game Boy", videoGame2.getConsole());
		assertEquals("Sega", videoGame3.getConsole());
		assertEquals("Action", videoGame3.getGenre());
	}

	@Test
	@SneakyThrows(UnsupportedEncodingException.class)
	public void sneakyThrowsTricksTheCompilerAndAvoidsAThrowClauseForCheckedExceptions() {
		String b = new String("hahaha".getBytes(), "UTF-8");
	}

	@Test
	public void logging() {
		ListAppender<ILoggingEvent> loggingAppender = LogTestUtil.getListAppenderForClass(VideoGame.class);
		videoGame.printLogMessage();
		assertEquals("Video games are fun!", loggingAppender.list.get(0).getMessage());
	}
}
