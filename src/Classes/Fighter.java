package Classes;

public abstract class Fighter {
// name, power, life e o objeto Special

	private String name;
	private double power;
	private double life;
	private Special Special;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getLife() {
		return life;
	}

	public void setLife(double life) {
		this.life = life;
	}

	public Special getSpecial() {
		return Special;
	}

	public void setSpecial(Special special) {
		Special = special;
	}

	// Liberando ataque básico
	public abstract void releasingBasicAttack(Fighter oponent);

	// Recebendo Ataque
	public abstract void gettingAttack(Fighter oponent);
//Para receber o dano perfurante de outros characters
	public abstract void gettingPiercingAttack(double d);

	public abstract void gettingAttack(Fighter oponent, double i);

// Soltando ataque especial
	public abstract void specialAttack(Fighter oponent);

}
