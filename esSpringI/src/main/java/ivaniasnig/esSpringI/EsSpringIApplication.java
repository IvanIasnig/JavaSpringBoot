package ivaniasnig.esSpringI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class EsSpringIApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EsSpringIApplication.class, args);

	}


}
