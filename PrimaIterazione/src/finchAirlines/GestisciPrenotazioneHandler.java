package finchAirlines;

public class GestisciPrenotazioneHandler {
	
	private VoloPrenotato[] listaVoli;

	public VoloPrenotato[] getListaVoli() {
		return listaVoli;
	}

	public void setListaVoli(VoloPrenotato[] listaVoli) {
		this.listaVoli = listaVoli;
	}

	public GestisciPrenotazioneHandler(int tipo_viaggio) {
		this.listaVoli = new VoloPrenotato[tipo_viaggio];
	}
	
	
	public void selezionaVoli(Volo voloScelto, int indice) {
		listaVoli[indice] = new VoloPrenotato(voloScelto); 	
	}
	
	public void selezionaPosto(String numeroPosto, String tipoPosto, int indice) {
		listaVoli[indice].setPosto(new Posto(numeroPosto, tipoPosto));
		
	}
	
	public void selezionaBagaglio(String bagaglioScelto, int indice) {
		listaVoli[indice].setBagaglio(new Bagaglio(bagaglioScelto));

		
	}
	
}
