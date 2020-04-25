package finchAirlines;

public class Posto {

	private String numero;
	private String tipo;

	public Posto(String numero) {
		this.numero = numero;
	}

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
	
	

}
