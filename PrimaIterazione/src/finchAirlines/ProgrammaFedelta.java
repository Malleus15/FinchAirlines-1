package finchAirlines;

public class ProgrammaFedelta {
	private String nome;
	private DescrizioneProgrammaFedelta descrizioneProgrammaFedelta;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProgrammaFedelta(String nome, double coefficientePunti) {
		this.nome = nome;
		this.descrizioneProgrammaFedelta = new DescrizioneProgrammaFedelta(coefficientePunti);
	}
	
	
	

}
