package Teste;

import Characters.*;
import Classes.Special;
import Game.Game;
import Player.Player;

public class Teste {

	public static void main(String[] args) {
		

		Player p1 = new Player("Gabriel", new Ryu(9, 100, new Special("Hadouken", 30)));
		Player p2 = new Player("Jose", new Bison(6, 130, new Special("Psycho Crusher", 15)));
		Player p3 = new Player("Mariana", new Ken(8, 95, new Special("Shoryuken", 35)));
		Player p4 = new Player("Antonio", new Blanka(7, 115, new Special("Electric Thunder", 20)));
		Game game = new Game(p1,p2);
		game.StartGame();
	}
}
