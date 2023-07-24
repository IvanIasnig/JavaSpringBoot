package ivaniasnig.lun_sett5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Decorators.AnanasDecorator;
import Decorators.CozzeDecorator;
import Decorators.SalameDecorator;

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
}
