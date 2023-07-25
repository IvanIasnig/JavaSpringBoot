package Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Coperto.Ordine;
import Coperto.Tavolo;
import Enum.StatoOrdine;
import Enum.StatoTavolo;
import ivaniasnig.lun_sett5.Bevande;
import ivaniasnig.lun_sett5.PizzaMargherita;

public class OrdineTest {

    @Test
    public void testTotale() {

    	PizzaMargherita pizza = new PizzaMargherita();
        Bevande bevanda = new Bevande("Fanta", 2,54);
        
        Tavolo tavolo = new Tavolo (12, 4, StatoTavolo.OCCUPATO);
        
        Ordine ordine = new Ordine(1, StatoOrdine.SERVITO, 2, LocalDateTime.now(), tavolo, Arrays.asList(pizza), Arrays.asList(bevanda));

        ordine.setCostoCoperto(2.0);

        Assertions.assertEquals(12.0, ordine.totale());
    }
    
}

