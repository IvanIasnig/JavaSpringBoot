package Decorators;

import ivaniasnig.lun_sett5.Pizza;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CozzeDecorator extends Pizza {

	public CozzeDecorator(Pizza pizza) {
		super(pizza.getName() + " con le cozze", pizza.getPrice() + 2, pizza.getCalorie() + 400);
		// TODO Auto-generated constructor stub
	}
	
}
