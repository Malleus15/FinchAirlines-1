package finchAirlines;

public class CartaCreditoAdapter {
	public boolean paga(CartaDiCredito cartaDiCredito, double nuovoTotale) {
		String numeroCarta = cartaDiCredito.getNumero();
		System.out.println("Pagamento presso istituto bancario con dati: " + numeroCarta + " prezzo: " + nuovoTotale);
		return true;
		/*simulazione API istituto bancaro con pagamento effettuato con successo 
		 *si suppone che il metodo di pagamento presso l'istituto sia pagamento(String, int)*/
	}
}
