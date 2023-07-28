package prova;

import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TATATA")
@NoArgsConstructor
@Getter
@Setter
public class Provina {
	@Id
	@GeneratedValue
	private UUID id;
	private String eta;

	public Provina(String eta) {
		this.eta = eta;
	}

	 
}
