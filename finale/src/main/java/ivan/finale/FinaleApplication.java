package ivan.finale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ivan.finale.classes.CentroControllo;
import ivan.finale.classes.Sensore;
import ivan.finale.factory.SensoreFactory;

@SpringBootApplication
public class FinaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinaleApplication.class, args);
		
		//------creazione sensore normalmente--------
		Sensore sensore = new Sensore("Ascoli12",18,100);
		System.out.println(sensore);
		
		//------creazione sensore da factory--------
		SensoreFactory factory = new SensoreFactory();
		Sensore sensore2 = factory.creaSensore("Napoli28",10, 50);
		System.out.println(sensore2);
		
		Sensore sensore3 = factory.creaSensore("Trieste2",10, 50);
		System.out.println(sensore3);
		
		//--------- creazione controllo ---------
		CentroControllo control = new CentroControllo();

		sensore.modObserver(control);
		sensore2.modObserver(control);
		sensore3.modObserver(control);
		
		sensore.setLivFumo(6);
		sensore2.setLivFumo(7);
		sensore3.setLivFumo(4);
	}
	

}
