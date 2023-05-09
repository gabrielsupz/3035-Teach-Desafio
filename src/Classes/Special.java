package Classes;

public class Special {
private String name;
private double specialValue;


public Special (String name, double value ){
	if(name == null || name.isEmpty()) {
		throw new RuntimeException("Nome vazio!");
	}
	if(value < 0) {
		throw new RuntimeException("Valor Especial Negativo!");
	}
	this.name = name;
	this.specialValue = value;
}

public  double specialAtackDemage() {

	return specialValue;
}
	
public String getSpecialName() {
	return name;
}

public void setSpecialValue(double v) {

	this.specialValue = v;
	if(specialValue < 0) {
		specialValue = 0;
	}
}
}

