package Decorators;

import ivaniasnig.lun_sett5.Pizza;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalameDecorator extends Pizza {
	
	public SalameDecorator(Pizza pizza) {
		super(pizza.getName() + " con il salame", pizza.getPrice() + 3, pizza.getCalorie() + 500);
		// TODO Auto-generated constructor stub
	}
	
}
