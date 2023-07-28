package ivaniasnig.lun_sett5;

import java.util.UUID;

import org.springframework.stereotype.Component;

import Coperto.Ordine;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name="Pizze")
@Getter
@Setter
//@Component
public abstract class Pizza extends Commestibile{
	
//	@Id
//	@GeneratedValue
//	private UUID id;
	
//	@ManyToOne
//	private Ordine ordine;

	public Pizza(String name, double price, double calorie) {
		super(name, price, calorie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pizza [calorie=" + calorie + ", name=" + name + ", price=" + price + "]";
	}

}
