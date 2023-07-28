package ivaniasnig.lun_sett5;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Merce")
@Getter
@Setter
@AllArgsConstructor
public abstract class Merce {
	@Id
	public String name;
	public double price;
}
