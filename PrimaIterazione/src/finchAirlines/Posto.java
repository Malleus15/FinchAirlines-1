package finchAirlines;

public class Posto {

	private String numero;
	private String tipo;


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public double calcolaPrezzo() {
		if(tipo.equalsIgnoreCase("base"))
			return 1;
		else if(tipo.equalsIgnoreCase("premium"))
			return 4;
		else if(tipo.equalsIgnoreCase("optimum"))
			return 10;
		else
			return 0;		
	}

	public Posto(String numero, String tipo) {
		this.numero = numero;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
