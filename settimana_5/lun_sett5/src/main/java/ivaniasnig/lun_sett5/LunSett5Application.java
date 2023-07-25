package ivaniasnig.lun_sett5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import Coperto.Ordine;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@PropertySource("classpath:application.properties")
public class LunSett5Application {

	public static void main(String[] args) {
		SpringApplication.run(LunSett5Application.class, args);
		
		configWithConfigAnnotation();

	}
	

	public static void configWithConfigAnnotation() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LunSett5Application.class);

		// log.info((String) ctx.getBean("getMaglietta"));
		log.info(ctx.getBean("getMaglietta").toString());

		log.info(ctx.getBean("getPalaPerPizzaiolo").toString());
		
		log.info(ctx.getBean("coca").toString());
		
		log.info(ctx.getBean("fanta").toString());
		
		log.info(ctx.getBean("pizzam").toString());
		
		log.info(ctx.getBean("pizzacozze").toString());
		
		log.info(ctx.getBean("pizzasalameEcozze").toString());
		
		log.info(ctx.getBean("pizzaCozzeEananas").toString());
		
		log.info(ctx.getBean("ordine").toString());
		
		log.info("Totale dell' ordine: " + ((Ordine) ctx.getBean("ordine")).totale());

		
		
		ctx.close();
	}
	
}
