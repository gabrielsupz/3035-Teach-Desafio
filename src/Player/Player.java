package Player;

import Classes.Fighter;

public class Player {

	private String name;
	private Fighter character;

	public Player(String name, Fighter character) {
		this.name = name;
		this.character = character;
	}

	public String getName() {
		return name;
	}

	public Fighter getCharacter() {
		return character;
	}

	public void attack(Player p) {
		if (this.equals(p)) {
			throw new RuntimeException(" Um player nao pode atacar a si mesmo!");
		}
	double preLife = p.character.getLife();
		character.releasingBasicAttack(p.getCharacter());

		System.out.println(p.character.getName() + " recebeu " + (preLife - p.character.getLife()) + " dano e ficou com "
				+ p.character.getLife() + " HP");

	}

	public void specialAttack(Player p) {
		if (this.equals(p)) {
			throw new RuntimeException(" Um player nao pode atacar a si mesmo!");
		}
		double preLife = p.character.getLife();
		character.specialAttack(p.getCharacter());
		
		System.out.println(p.character.getName() + " recebeu o ataque especial "
				+ character.getSpecial().getSpecialName() + " levando " + (preLife - p.character.getLife())
				+ " de dano,ficando com " + p.character.getLife() + " HP");

	}
}