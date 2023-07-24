package Decorators;

import ivaniasnig.lun_sett5.Pizza;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnanasDecorator extends Pizza{
	public AnanasDecorator(Pizza pizza) {
		super(pizza.getName() + " con l' ananas", pizza.getPrice() + 100, pizza.getCalorie() - 800);
		// TODO Auto-generated constructor stub
	}

}
