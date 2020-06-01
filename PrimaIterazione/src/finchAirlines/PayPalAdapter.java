package finchAirlines;

public class PayPalAdapter {

	public boolean paga(ContoPayPal contoPayPal, double nuovoTotale) {
		String email = contoPayPal.getEmail();
		System.out.println("Pagamento presso PayPal.com con dati: " + email + " prezzo: " + nuovoTotale);
		return true;
		/*simulazione API di PayPal con pagamento effettuato con successo 
		 *si suppone che il metodo di pagamento presso paypal sia pagamento(String, int)*/
	}
}
