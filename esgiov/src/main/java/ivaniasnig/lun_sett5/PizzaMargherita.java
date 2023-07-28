package ivaniasnig.lun_sett5;

public class PizzaMargherita extends Pizza {

	public PizzaMargherita() {
		super("Pizza margherita", 6, 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PizzaMargherita [calorie=" + getCalorie() + ", name=" + getName() + ", price=" + getPrice() + "]";
	}

}
