package Game;

import Player.Player;

public class Game {

	private Player p1;
	private Player p2;
private String winner;


	public Game(Player p1, Player p2) {
		if (p1 == p2) {
			throw new RuntimeException("Mesmo player declarado duas vezes");

		}
		this.p1 = p1;
		this.p2 = p2;
	}
	
	

	public void StartGame() {

		System.out.println("Player 1: " + p1.getName() + "/" + p1.getCharacter().getName() + " VS " + "Player 2: "
				+ p2.getName() + "/" + p2.getCharacter().getName());

		// A partida segue o padrão de 2 ataques básicos de cada player seguido por um
		// especial

		game: while (p1.getCharacter().getLife() > 0 | p2.getCharacter().getLife() > 0) {

			for (int i = 0; i < 2; i++) {
				p1.attack(p2);
				if (p2.getCharacter().getLife() <= 0) {
					System.out.println(p1.getName() + "/" + p1.getCharacter().getName() + ": "+ p1.getCharacter().getLife()+ "HP");
					System.out.println(p2.getName() + "/" + p2.getCharacter().getName() + ": "+ p2.getCharacter().getLife()+ "HP");

				
					break game;
				}

				p2.attack(p1);
				if (p1.getCharacter().getLife() <= 0) {
					System.out.println(p1.getName() + "/" + p1.getCharacter().getName() + ": "+ p1.getCharacter().getLife()+ "HP");
					System.out.println(p2.getName() + "/" + p2.getCharacter().getName() + ": "+ p2.getCharacter().getLife()+ "HP");

				
					break game;
				}
			}

			p1.specialAttack(p2);
			if (p2.getCharacter().getLife() <= 0) {
				System.out.println(p1.getName() + "/" + p1.getCharacter().getName() + ": "+ p1.getCharacter().getLife()+ "HP");
				System.out.println(p2.getName() + "/" + p2.getCharacter().getName() + ": "+ p2.getCharacter().getLife()+ "HP");

		
				break;
			}
			p2.specialAttack(p1);
			if (p1.getCharacter().getLife() <= 0) {
				System.out.println(p1.getName() + "/" + p1.getCharacter().getName() + ": "+ p1.getCharacter().getLife()+ "HP");
				System.out.println(p2.getName() + "/" + p2.getCharacter().getName() + ": "+ p2.getCharacter().getLife()+ "HP");

				
				break;
			}
			
				

		}
		;
		if(p1.getCharacter().getLife() < 0) {
			winner = p2.getName();
			System.out.println("Vencedor: " + winner);
		}if(p2.getCharacter().getLife() < 0) {
			winner = p1.getName();
			System.out.println("Vencedor: " + winner);
		}if(p1.getCharacter().getLife() <= 0 && p2.getCharacter().getLife() <= 0) {
			//Possivel 
			winner = "Empate";
			System.out.println(winner);
		}
	}



	public String getWinner() {
		return winner;
	}
}
