package finchAirlines;

import java.time.LocalDateTime;

public class Documento {

	private String id;
	private LocalDateTime dataRilascio;
	private LocalDateTime dataScadenza;
	private String tipo;
	
	public Documento(String id, LocalDateTime localDateTime, LocalDateTime localDateTime2, String tipo) {
		this.id = id;
		this.dataRilascio = localDateTime;
		this.dataScadenza = localDateTime2;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(LocalDateTime dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

	public LocalDateTime getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDateTime dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
