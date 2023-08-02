package ivaniasnig.esMercoledi.classi;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrenotazionePayload {
	private LocalDate dataPrenotazione;
	private int postazioneId;
	private String username;
}
