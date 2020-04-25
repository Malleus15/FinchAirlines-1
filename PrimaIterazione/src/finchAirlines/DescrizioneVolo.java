package finchAirlines;

public class DescrizioneVolo {

	private String codice;
	private double prezzo;
	private Aeroporto[] aeroporti;
	
	public DescrizioneVolo(String codice, double prezzo, Aeroporto[] aeroporti) {
		this.codice = codice;
		this.prezzo = prezzo;
		this.aeroporti = aeroporti;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Aeroporto[] getAeroporti() {
		return aeroporti;
	}

	public void setAeroporti(Aeroporto[] aeroporti) {
		this.aeroporti = aeroporti;
	}
	
	
	
	
}
