package Characters;

import Classes.*;

public class Ryu extends Fighter {
	// Regras especiais: Protagonista, Ataques derradeiros
	// Ganha bonus de power quando atinge metade da vida
	// O dano do seu especial ganha bonus ao atingir 50% da vida
	// Sua defesa é mediana, redução de dano = 2

	private double OriginalLife;

	public Ryu(double power, double life, Special special) {
		if(power < 0 || life  <0 ) {
			throw new RuntimeException("Poder e vida não podem ser negativos");
		}
		setName("Ryu");
		setLife(life);
		this.OriginalLife = life;
		setPower(power);
		setSpecial(special);
	}

	public void releasingBasicAttack(Fighter oponent) {

		oponent.gettingAttack(this);
	}

	public void gettingAttack(Fighter oponent) {
		double demage = oponent.getPower();

		double newLife = 2 + (getLife() - demage);
		if (newLife <= OriginalLife / 2) {
			setPower(getPower() + 1);
			OriginalLife = 0;
		}
		setLife(newLife);

	}

	public void gettingPiercingAttack(double d) {
		double newLife = getLife() - d;

		setLife(newLife);

	}

	public void gettingAttack(Fighter oponent, double d) {
		double specialDemage = oponent.getSpecial().specialAtackDemage();

		double newLife = getLife() + 2 - (specialDemage + d);

		setLife(newLife);

	}

	public void specialAttack(Fighter oponent) {
		if ((this.getLife() * 100) / this.OriginalLife <= 50) {

			oponent.gettingAttack(this, 5);

		} else
			oponent.gettingAttack(this, 0);

	}

}
