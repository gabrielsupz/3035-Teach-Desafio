package Characters;

import Classes.Fighter;
import Classes.Special;

public class Blanka extends Fighter {
	private double originalLife;
	// Regras especiais: Dócil-Feroz , Brasileiro
	// Seu ataque especial evolui quando atinge 50% de sua vida e o dano do mesmo
	// aumenta em 10 antes de cada uso
	// Por ser Brasileiro ele ganha um bonus de +2 de dano
	// Sua defesa é fraca,+1 de redução de dano, mas suas descargas elétricas causam
	// 1.5 de dano perfurante quando ele é atacado

	public Blanka( double power, double life, Special special) {
		if(power < 0 || life  <0 ) {
			throw new RuntimeException("Poder e vida não podem ser negativos");
		}
		
		originalLife = life;
		setName("Blanka");
		setLife(life);
		setPower(power);
		setSpecial(special);
	}

	public void releasingBasicAttack(Fighter oponent) {

		oponent.gettingAttack(this);
	}

	public void gettingAttack(Fighter oponent) {
		oponent.gettingPiercingAttack(1.5);
		double demage = oponent.getPower();
		
		
		double newLife =  1 +(getLife() - demage) ;
		
		setLife(newLife);

	}
	public void gettingPiercingAttack(double d) {
		double newLife = getLife() - d;
	
		setLife(newLife);

	}

	public void gettingAttack(Fighter oponent, double d) {
		double specialDemage = oponent.getSpecial().specialAtackDemage();

		double newLife = getLife() + 1 - (specialDemage + d);

		setLife(newLife);

	}

	public void specialAttack(Fighter oponent) {
	if(this.getLife() <= (originalLife * 100 ) / 50 ) {
		this.setSpecial(new Special("Ground Shave Rolling", (10 + this.getSpecial().specialAtackDemage())));
	}
			oponent.gettingAttack(this, 0);

	}
	

}