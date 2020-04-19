package finchAirlines;

import java.util.Date;

public class Volo {

	private Date oraPartenza;
	private Date oraArrivo;
	private DescrizioneVolo descrizioneVolo;
	
	public Volo(Date oraPartenza, Date oraArrivo, DescrizioneVolo descrizioneVolo) {
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraArrivo;
		this.descrizioneVolo = descrizioneVolo;
	}

	public Date getOraPartenza() {
		return oraPartenza;
	}

	public void setOraPartenza(Date oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	public Date getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(Date oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	public DescrizioneVolo getDescrizioneVolo() {
		return descrizioneVolo;
	}

	public void setDescrizioneVolo(DescrizioneVolo descrizioneVolo) {
		this.descrizioneVolo = descrizioneVolo;
	}
	
	
	
	

}
