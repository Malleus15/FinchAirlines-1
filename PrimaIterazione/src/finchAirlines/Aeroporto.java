package finchAirlines;
/*Commento di prov a*/
public class Aeroporto {

	private String nome;
	private String citta;
	private String codice;
	
	public Aeroporto(String nome, String citta, String codice) {
		this.nome = nome;
		this.citta = citta;
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	
	
	

}
