package ivaniasnig.lun_sett5;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Commestibile extends Merce {
	public double calorie;

	public Commestibile(String name, double price, double calorie) {
		super(name, price);
		this.calorie = calorie;
		// TODO Auto-generated constructor stub
	}
	
}
