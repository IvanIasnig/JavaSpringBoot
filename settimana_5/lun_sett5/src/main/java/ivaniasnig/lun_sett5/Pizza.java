package ivaniasnig.lun_sett5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Pizza extends Commestibile{

	public Pizza(String name, double price, double calorie) {
		super(name, price, calorie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pizza [calorie=" + calorie + ", name=" + name + ", price=" + price + "]";
	}

}
