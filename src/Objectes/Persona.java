package Objectes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Persona implements Serializable {
	private int dorsal;
	private static int dorsals;
	private String dni;
	private String nom;
	private String cognom;
	private LocalDate dataNaix;
	private int edat;
	private int telefon;
	private String email;

	@Override

	public String toString() {
		return getClass().getSimpleName() + " dni=" + dni + " Dorsal=" + dorsal + ", nom=" + nom + ", cognom=" + cognom
				+ ", dataNaix=" + dataNaix + " edat= " + calcularEdat() + ", email=" + email + " telefon=" + telefon
				+ " ";
	}

	public Persona(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email) {
		this.dni = dni;
		this.nom = nom;
		this.cognom = cognom;
		this.dataNaix = dataNaix;
		this.telefon = telefon;
		this.email = email;
		this.dorsal = ++dorsals;

		edat = Period.between(dataNaix, LocalDate.now()).getYears();
	}

	public int calcularEdat() {
		edat = Period.between(dataNaix, LocalDate.now()).getYears();
		return edat;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public static int getDorsals() {
		return dorsals;
	}

	public static void setDorsals(int dorsals) {
		Persona.dorsals = dorsals;
	}

	public String getdni() {
		return dni;
	}

	public void setdni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public LocalDate getDataNaix() {
		return dataNaix;
	}

	public void setDataNaix(LocalDate dataNaix) {
		this.dataNaix = dataNaix;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
