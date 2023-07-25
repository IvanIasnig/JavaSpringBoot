package Coperto;

import Enum.StatoTavolo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tavolo {
	private int numero;
	private int maxCoperti;
	private StatoTavolo stato;
	
	public Tavolo(int numero, int maxCoperti, StatoTavolo stato) {
		this.numero = numero;
		this.maxCoperti = maxCoperti;
		this.stato = stato;
	}
	
	
}
