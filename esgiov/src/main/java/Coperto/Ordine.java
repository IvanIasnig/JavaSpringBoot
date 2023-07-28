package Coperto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import Enum.StatoOrdine;
import ivaniasnig.lun_sett5.Bevande;
import ivaniasnig.lun_sett5.Pizza;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name="Ordini")
@Setter
@Getter
@ToString
@NoArgsConstructor
//@Component
public class Ordine {
//	@Id
//	@GeneratedValue
//	private UUID id;
	
	private int numeroOrdine;

//	@Enumerated(EnumType.STRING)
	private StatoOrdine ordine;
	
	private int numCoperti;

	private LocalDateTime oraComanda;
	
	@Value("${application.costoCoperto}")
	private double costoCoperto;
	
//	@OneToOne
	private Tavolo tavolo;

	
//	@OneToMany(mappedBy = "ordine")
	private List<Pizza> pizze;

//	@OneToMany(mappedBy = "ordine")
	private List<Bevande> bevande;
	
	
	public Ordine(int numeroOrdine, StatoOrdine ordine, int numCoperti, LocalDateTime oraComanda,
			 Tavolo tavolo, List<Pizza> pizze, List<Bevande> bevande) {
		this.numeroOrdine = numeroOrdine;
		this.ordine = ordine;
		this.numCoperti = numCoperti;
		this.oraComanda = oraComanda;
		this.tavolo = tavolo;
		this.pizze = pizze;
		this.bevande = bevande;
}
	
	public double totale() {
		List<Pizza> listaPizze =  this.getPizze();
		List<Bevande> listaBevande =  this.getBevande();

		
		double somma = 0;
		for(int i = 0; i<listaPizze.size(); i++) {
		somma = somma + pizze.get(i).getPrice();	
		}
		
		for(int i = 0; i<listaBevande.size(); i++) {
		somma = somma + bevande.get(i).getPrice();	
		}
		
		somma = somma + (this.numCoperti * this.costoCoperto);
		
		return somma;
	}
	
	
}
