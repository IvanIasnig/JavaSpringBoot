package ivan.finale.interfaces;

public interface EventListener {
	public void modObserver(Observer obs); //ho visto che in genere si fa con l'obeservable (EventListener), potevo anche levare l'interface e l'annotation @Override dai metodi nella classe Sensore
	public void notiObserver();
}
