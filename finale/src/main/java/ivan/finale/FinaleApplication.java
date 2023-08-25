package ivan.finale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ivan.finale.classes.Sensore;

@SpringBootApplication
public class FinaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinaleApplication.class, args);
		
		Sensore sensore = new Sensore(18,100);
		sensore.setLivFumo(6);
		System.out.println(sensore);
	}

}
