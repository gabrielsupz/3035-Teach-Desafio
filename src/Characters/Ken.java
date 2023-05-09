package Characters;

import Classes.Fighter;
import Classes.Special;

public class Ken extends Fighter {
	private double OriginalLife;
	// Regras especiais: Carateca , Guerreiro
	// A primeira vez que sua vida zerar ela retorna a 10
	// O dano do seu special Attack reduz em 3 a cada utilização e aumenta seu power
	// na mesma quantia
	// Sua defesa é mediana, redução de dano = 2

	public Ken(double power, double life, Special special) {
		if(power < 0 || life  <0 ) {
			throw new RuntimeException("Poder e vida não podem ser negativos");
		}
		setName("Ken");
		setLife(life);
		setPower(power);
		setSpecial(special);
	}

	public void releasingBasicAttack(Fighter oponent) {

		oponent.gettingAttack(this);
	}

	public void gettingAttack(Fighter oponent) {
		double demage = oponent.getPower();

		double newLife = 2 + (getLife() - demage);

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

		oponent.gettingAttack(this, 0);
		if (this.getSpecial().specialAtackDemage() >= 0) {
			this.getSpecial().setSpecialValue(this.getSpecial().specialAtackDemage() - 3);
			this.setPower(this.getPower() + 3);
		}

	}

}