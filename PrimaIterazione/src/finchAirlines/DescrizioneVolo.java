package finchAirlines;

public class DescrizioneVolo {

	private String codice;
	private double prezzo;
	private Aeroporto[] aeroporti = new Aeroporto[2];
	
	public DescrizioneVolo(String codice, double prezzo, Aeroporto aeroporto1, Aeroporto aeroporto2) {
		this.codice = codice;
		this.prezzo = prezzo;
		this.aeroporti[0]=aeroporto1;
		this.aeroporti[1]=aeroporto2;
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
