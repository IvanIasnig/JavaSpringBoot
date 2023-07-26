package Coperto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import Enum.StatoOrdine;
import ivaniasnig.lun_sett5.Bevande;
import ivaniasnig.lun_sett5.Pizza;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Ordine {
	private int numeroOrdine;
	private StatoOrdine ordine;
	private int numCoperti;
	private LocalDateTime oraComanda;
	@Value("${application.costoCoperto}")
	private double costoCoperto;
	private Tavolo tavolo;
	private List<Pizza> pizze;
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
