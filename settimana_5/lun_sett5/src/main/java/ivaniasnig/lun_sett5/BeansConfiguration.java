package ivaniasnig.lun_sett5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Coperto.Ordine;
import Coperto.Tavolo;
import Decorators.AnanasDecorator;
import Decorators.CozzeDecorator;
import Decorators.SalameDecorator;
import Enum.StatoOrdine;
import Enum.StatoTavolo;

@Configuration
public class BeansConfiguration {


	@Bean (name = "getMaglietta")
	Oggettistica maglietta() {
		return new Oggettistica("Maglietta nera", 10);
	}
	
	@Bean (name = "getPalaPerPizzaiolo")
	Oggettistica palaPerPizzaiolo() {
		return new Oggettistica("Bella pala", 20);
	}
	
	@Bean 
	Bevande coca() {
		return new Bevande("Coca cola", 10 ,156);
	}
	
	@Bean 
	Bevande fanta() {
		return new Bevande("Fanta", 20,54);
	}
	
	@Bean
	PizzaMargherita pizzam() {
		return new PizzaMargherita();
	}
	
	@Bean
	Pizza pizzacozze() {
		return new CozzeDecorator(new PizzaMargherita());
	}
	
	@Bean
	Pizza pizzasalameEcozze() {
		return new SalameDecorator(new CozzeDecorator(new PizzaMargherita()));
	}
	
	@Bean
	Pizza  pizzaCozzeEananas() {
		return new CozzeDecorator(new AnanasDecorator(new PizzaMargherita()));
	}
	
	@Bean
	Tavolo tavolo() {
		return new Tavolo (12, 4, StatoTavolo.OCCUPATO);
	}
	
	@Bean
	Ordine ordine() {
	    List<Pizza> listaPizze = new ArrayList<>();
	    listaPizze.add(pizzaCozzeEananas());
	    listaPizze.add(pizzasalameEcozze());
	    listaPizze.add(pizzacozze());

	    
	    List<Bevande> listaBevande = new ArrayList<>();
	    listaBevande.add(fanta());
	    
	    return new Ordine (1, StatoOrdine.SERVITO, 3, LocalDateTime.now(), tavolo(), listaPizze, listaBevande);
	}
	
	

	
}
