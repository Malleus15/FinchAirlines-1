package finchAirlines;

public class VoloPrenotato {

	private Posto posto;
	private Bagaglio bagaglio;
	private Volo volo;
	private boolean checkin;
	
	public VoloPrenotato(Posto posto, Bagaglio bagaglio, Volo volo) {
		this.posto = posto;
		this.bagaglio = bagaglio;
		this.volo = volo;
		this.checkin = false;
	}
	
	public boolean isCheckin() {
		return checkin;
	}

	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}

	public VoloPrenotato(Volo volo) {
		this.volo = volo;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public Bagaglio getBagaglio() {
		return bagaglio;
	}

	public void setBagaglio(Bagaglio bagaglio) {
		this.bagaglio = bagaglio;
	}

	public Volo getVolo() {
		return volo;
	}

	public void setVolo(Volo volo) {
		this.volo = volo;
	}
	
	
	
	

}
