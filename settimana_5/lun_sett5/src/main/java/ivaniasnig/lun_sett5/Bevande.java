package ivaniasnig.lun_sett5;

public class Bevande extends Commestibile {

	public Bevande(String name, double price, double calorie) {
		super(name, price, calorie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bevande [calorie=" + calorie + ", name=" + name + ", price=" + price + "]";
	}
	
}
