package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Characters.*;

import Classes.Special;
import Game.Game;
import Player.Player;
import junit.framework.Assert;

public class GameTest {

	@Test
	public void ganhadorDaPartida() {

		Player p1 = new Player("Gabriel", new Ryu(9, 100, new Special("Hadouken", 30)));
		Player p2 = new Player("Jose", new Bison(6, 130, new Special("Psycho Crusher", 15)));
		Player p3 = new Player("Mariana", new Ken(8, 95, new Special("Shoryuken", 35)));
		Player p4 = new Player("Antonio", new Blanka(7, 115, new Special("Electric Thunder", 20)));

		Game game = new Game(p1, p2);
	// Eu deixei bastantes sysout que mostram como decorreu a luta;
		game.StartGame();

		assertEquals((p2.getCharacter().getLife() <= 0), (game.getWinner() == p1.getName()));
		assertEquals((p1.getCharacter().getLife() <= 0), (game.getWinner() == p2.getName()));

	}

	@Test
	public void testeEmpate() {

		Player p1TesteEmpate = new Player("Antonio", new Blanka(7, 0, new Special("Electric Thunder", 20)));
		Player p2TesteEmpate = new Player("Antonia", new Blanka(7, 0, new Special("Electric Thunder", 20)));

		Game game = new Game(p1TesteEmpate, p2TesteEmpate);
		game.StartGame();

		assertEquals(p1TesteEmpate.getCharacter().getLife() <= 0 && p2TesteEmpate.getCharacter().getLife() <= 0,
				game.getWinner() == "Empate");

	}

	@Test
	public void gameNaoPodeSerCriadoComUnicoPlayer() {

		Player p1 = new Player("Gabriel", new Ryu(9, 100, new Special("Hadouken", 30)));

		assertThrows(RuntimeException.class, () -> new Game(p1, p1));

		;

	}

	@Test
	public void especialNaoPodeTerNomeNullOuVazio() {

		assertThrows(RuntimeException.class, () -> new Player("Gabriel", new Ryu(9, 100, new Special("", 30))));
		assertThrows(RuntimeException.class, () -> new Player("Gabriel", new Ryu(9, 100, new Special(null, 30))));

		;

	}

	@Test
	public void especialNaoPodeTerSeuValorNegativo() {

		assertThrows(RuntimeException.class, () -> new Special("Hadouken", -30));

		;

	}

	@Test
	public void poderEVidaNaoPodemSerNegativos() {
		// Normalmente o poder e a vida não poderiam ser 0, mas para facilitar e
		// como não foi especificado no desafio eu deixei esta possibilidade.

		assertThrows(RuntimeException.class,
				() -> new Player("Gabriel", new Ryu(-9, 100, new Special("Hadouken", 30))));
		assertThrows(RuntimeException.class,
				() -> new Player("Gabriel", new Ryu(9, -100, new Special("Hadouken", 30))));

		;

	}

}
