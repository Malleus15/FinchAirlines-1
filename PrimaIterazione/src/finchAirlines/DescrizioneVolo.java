package finchAirlines;

public class DescrizioneVolo {

	private String codice;
	private Aeroporto[] aeroporti = new Aeroporto[2];
	private ProgrammaFedelta programmaFedelta;
	
	public DescrizioneVolo(String codice, Aeroporto[] tratta) {
		this.codice = codice;
		this.aeroporti[0]=tratta[0];
		this.aeroporti[1]=tratta[1];
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Aeroporto[] getAeroporti() {
		return aeroporti;
	}

	public void setAeroporti(Aeroporto[] aeroporti) {
		this.aeroporti = aeroporti;
	}
	
	public void assegnaProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
		this.programmaFedelta = programmaFedelta;
	}

	public ProgrammaFedelta getProgrammaFedelta() {
		return programmaFedelta;
	}
	
	
	
	
}
