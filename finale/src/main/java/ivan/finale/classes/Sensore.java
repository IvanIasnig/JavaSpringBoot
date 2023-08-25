package ivan.finale.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ivan.finale.interfaces.Observable;
import ivan.finale.interfaces.Observer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Sensore implements Observable {

	
	private String id;
	private int livFumo;
	double latitudine;
	double longitudine; 
	private ArrayList<Observer> observer;
	
	public Sensore(String id,double latitudine, double longitudine) {
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.observer = new ArrayList<>();
	}
	
	public void setLivFumo(int liv) {
		this.livFumo = liv;
		if (this.livFumo > 5) {
			notiObserver();
		}
	}
	
	@Override
	public void modObserver(Observer obs) {
		observer.add(obs);
	}
	
	@Override
	public void notiObserver() {
		for (int i = 0; i< observer.size(); i++) {
			observer.get(i).aggiorna(livFumo, latitudine, longitudine);
		}
	}

	@Override
	public String toString() {
		return "Sensore [id=" + id + ", livFumo=" + livFumo + ", latitudine=" + latitudine + ", longitudine="
				+ longitudine + "]";
	};
	

 
}