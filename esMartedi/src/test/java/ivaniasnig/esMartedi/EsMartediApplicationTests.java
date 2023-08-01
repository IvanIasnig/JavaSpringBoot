package ivaniasnig.esMartedi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EsMartediApplicationTests {

	    @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void prenotazioniRegole() throws Exception {

	        mockMvc.perform(get("/booking-rules")
	                        .param("lang", "it")
	                        .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	    
	}

}
