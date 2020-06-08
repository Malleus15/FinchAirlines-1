package finchAirlines;

import java.time.LocalDateTime;

public class Volo {

	private LocalDateTime oraPartenza;
	private LocalDateTime oraArrivo;
	private DescrizioneVolo descrizioneVolo;
	private double prezzo;
	
	public Volo() {
	}

	public LocalDateTime getOraPartenza() {
		return oraPartenza;
	}

	public void setOraPartenza(LocalDateTime oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	public LocalDateTime getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(LocalDateTime oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	public DescrizioneVolo getDescrizioneVolo() {
		return descrizioneVolo;
	}

	public void setDescrizioneVolo(DescrizioneVolo descrizioneVolo) {
		this.descrizioneVolo = descrizioneVolo;
	}
	
	public boolean controllaData() {
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime dataCheckin = this.oraPartenza.minusDays(7);
		if(dataCheckin.isBefore(today) && this.oraPartenza.isAfter(today))
			return true;
		return false;
		
	}
	
	public void riempiDettagliVolo(DescrizioneVolo descrizioneVolo, double prezzo, LocalDateTime oraPartenza, LocalDateTime oraArrivo) {
		this.descrizioneVolo = descrizioneVolo;
		this.prezzo = prezzo;
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraArrivo;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	

}
