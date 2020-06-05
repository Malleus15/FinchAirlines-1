package finchAirlines;

import java.time.LocalDateTime;

public class Volo {

	private LocalDateTime oraPartenza;
	private LocalDateTime oraArrivo;
	private DescrizioneVolo descrizioneVolo;
	
	public Volo(LocalDateTime oraPartenza, LocalDateTime oraArrivo, DescrizioneVolo descrizioneVolo) {
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraArrivo;
		this.descrizioneVolo = descrizioneVolo;
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
	
	

}
