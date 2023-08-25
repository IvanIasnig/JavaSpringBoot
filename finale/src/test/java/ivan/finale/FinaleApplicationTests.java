package ivan.finale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ivan.finale.classes.Sensore;

@SpringBootTest
class FinaleApplicationTests {



    @Test
    public void testSetLivFumo() {
    	Sensore sensore = new Sensore("Milano25",40, 74.5);
        sensore.setLivFumo(4);
        assertEquals(4, sensore.getLivFumo());
    }
    
    @Test
    public void testLatitudine() {
    	Sensore sensore = new Sensore("Milano25",40, 74.5);
        sensore.setLivFumo(5);
        assertEquals(40, sensore.getLatitudine());
    }
    
    @Test
    public void testLongitudine() {
    	Sensore sensore = new Sensore("Milano25",40, 74.5);
        sensore.setLivFumo(7);
        assertEquals(74.5, sensore.getLongitudine());
    }

}
