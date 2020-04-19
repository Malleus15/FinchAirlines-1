package finchAirlines;

import java.util.Date;

public class Documento {

	private String id;
	private Date dataRilascio;
	private Date dataScadenza;
	private String tipo;
	
	public Documento(String id, Date dataRilascio, Date dataScadenza, String tipo) {
		this.id = id;
		this.dataRilascio = dataRilascio;
		this.dataScadenza = dataScadenza;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(Date dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
