package giov.es.classes;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info { 
    private String nome; 
    private String cognome; 
    private LocalDate dataDiNascita; 

}

