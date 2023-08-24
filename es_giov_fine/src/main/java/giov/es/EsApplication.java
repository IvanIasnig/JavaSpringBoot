package giov.es;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import giov.es.classes.Info;
import giov.es.classes.InfoAdapter;
import giov.es.classes.UserData;

@SpringBootApplication
public class EsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class, args);
        
        Info info = new Info();
        info.setNome("Ivan");
        info.setCognome("Iasnig");

        LocalDate compleanno = LocalDate.of(1998, 9, 23);
        info.setDataDiNascita(compleanno);

        InfoAdapter adapter = new InfoAdapter(info);

        UserData userData = new UserData();
        userData.getData(adapter);

        System.out.println("Nome: " + userData.getNomeCompleto());
        System.out.println("Età: " + userData.getEta());
    }


}
