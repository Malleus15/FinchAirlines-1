package finchAirlines;

public class Cliente {

	private String nome;
	private String cognome;
	private String email;
	private String telefono;
	private String password;
	private Documento documento;

	public Cliente(String nome, String cognome, String email, String telefono, String password, Documento documento) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.documento = documento;
	}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public Documento getDocumento() {
		return documento;
	}



	public void setDocumento(Documento documento) {
		this.documento = documento;
	}



	public boolean verificaPassword(String password) {
		if(password == this.password)
			return true;
		else
			return false;
	}

}
