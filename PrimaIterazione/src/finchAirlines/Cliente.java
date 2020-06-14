package finchAirlines;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  

@Entity
@Table(name="cliente")
public class Cliente implements Authenticator{

	private String nome;
	private String cognome;
	private String email;
	private String telefono;
	private String password;	
	private Documento documento;
	private int punti;

	public Cliente(String nome, String cognome, String email, String telefono, String password, Documento documento) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.documento = documento;
		this.punti = 0;
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
	
	
	public int getPunti() {
		return punti;
	}
	
	
	public void setPunti(int punti) {
		this.punti = punti;
	}

	@Override
	public boolean verificaPassword(String password) {
		if(password.equals(this.password))
			return true;
		else
			return false;
	}
	
	public void decrementaPunti(int puntiSelezionati) {
		this.punti = this.punti - puntiSelezionati;
	}
	
	public int incrementaPunti(double coefficientePunti, double prezzo) {
		int punti =  (int) (coefficientePunti*prezzo);
		this.punti = this.punti + punti;
		return punti;
	}

}
