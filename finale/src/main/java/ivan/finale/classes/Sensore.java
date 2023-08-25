package ivan.finale.classes;

import java.util.ArrayList;

import ivan.finale.interfaces.EventListener;
import ivan.finale.interfaces.Observer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sensore implements EventListener {

	
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
		if (liv > 5) {
			notiObserver();
		} else {
			System.out.println("Fumo nella norma per il sensore " + this.id);
		}
	}
	
	@Override
	public void modObserver(Observer obs) {
		observer.add(obs);
	}
	
	@Override
	public void notiObserver() {
		for (int i = 0; i< observer.size(); i++) {
			observer.get(i).aggiorna(id,livFumo, latitudine, longitudine);
		}
	}

	@Override
	public String toString() {
		return "Sensore [id=" + id + ", livFumo=" + livFumo + ", latitudine=" + latitudine + ", longitudine="
				+ longitudine + "]";
	};
	

 
}
