package finchAirlines;

public class PayPalAdapter {

	public boolean paga(ContoPayPal conto, double nuovoTotale) {
		String email = conto.getEmail();
		System.out.println("Pagamento presso PayPal.com con dati: " + email + " prezzo: " + nuovoTotale);
		return true;
		/*simulazione API di PayPal con pagamento effettuato con successo 
		 *si suppone che il metodo di pagamento presso paypal sia pagamento(String, int)*/
	}
}
