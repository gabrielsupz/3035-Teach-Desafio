package Characters;

import Classes.Fighter;
import Classes.Special;

public class Bison extends Fighter {
	// Regras especiais: Boss Final, Alto Ego
	// Tem um bonus de 20% de vida
	// Seu ataque especial irá começar em 5,mas a cada utilização ficará mais forte
	// Sua defesa é boa, redução de dano = 4

	public Bison(double power, double life, Special special) {
		if(power < 0 || life  <0 ) {
			throw new RuntimeException("Poder e vida não podem ser negativos");
		}

		double bonusLife = (life * 20) / 100;
		setName("M. Bison");
		setLife(bonusLife + life);
		setPower(power);
		setSpecial(special);
		this.getSpecial().setSpecialValue(5);
	}

	public void releasingBasicAttack(Fighter oponent) {
		oponent.gettingAttack(this);
	}

	public void gettingAttack(Fighter oponent) {
		double demage = oponent.getPower();

		double newLife = 4 + (getLife() - demage);

		setLife(newLife);

	}
	public void gettingPiercingAttack(double d) {
		double newLife = getLife() - d;
	
		setLife(newLife);

	}

	public void gettingAttack(Fighter oponent, double d) {
		double specialDemage = oponent.getSpecial().specialAtackDemage();

		double newLife = getLife() + 4 - (specialDemage + d);

		setLife(newLife);

	}

	public void specialAttack(Fighter oponent) {

		oponent.gettingAttack(this,0);
		this.getSpecial().setSpecialValue(this.getSpecial().specialAtackDemage() + 10);

	}

}