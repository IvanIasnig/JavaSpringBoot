package Coperto;

import java.util.UUID;

import org.springframework.stereotype.Component;

import Enum.StatoTavolo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Entity
//@Table(name="Tavoli")
//@NoArgsConstructor
//@Component
public class Tavolo {
//	@Id
//	@GeneratedValue
//	private UUID id;


	private int numero;

	private int maxCoperti;

//	@Enumerated(EnumType.STRING)
	private StatoTavolo stato;
	
	public Tavolo(int numero, int maxCoperti, StatoTavolo stato) {
		this.numero = numero;
		this.maxCoperti = maxCoperti;
		this.stato = stato;
	}
	
}
