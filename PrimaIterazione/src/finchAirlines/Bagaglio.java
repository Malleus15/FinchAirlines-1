package finchAirlines;

public class Bagaglio {

	private String tipo;

	public Bagaglio(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double calcolaPrezzo() {
		if(tipo.equalsIgnoreCase("mano"))
			return 2.50;
		else if(tipo.equalsIgnoreCase("10kg"))
			return 5;
		else if(tipo.equalsIgnoreCase("20kg"))
			return 15;
		else
			return 0;		
	}
	
	
	
	

}
