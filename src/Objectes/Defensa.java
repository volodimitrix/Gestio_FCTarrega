package Objectes;

import java.time.LocalDate;

public class Defensa extends JugadorsBalonsRecuperats {
	private int atacsAturats;

	@Override
	public void calcularSalari() {
		this.salari = (souBase + (atacsAturats * 2) + (this.balonsRecuperats * 2));

	}

	@Override
	public String toString() {
		return super.toString() + " atacsAturats=" + atacsAturats + "]";
	}

	public Defensa(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email, int souBase,
			String nSS, boolean esTitular, int balonsRecuperats, int atacsAturats) {

		super(dni, nom, cognom, dataNaix, telefon, email, souBase, nSS, esTitular, balonsRecuperats);

		this.atacsAturats = atacsAturats;

		calcularSalari();
	}

	@Override
	public void setGolsFets(int golsFets) {

	}

	public int getAtacsAturats() {
		return atacsAturats;
	}

	public void setAtacsAturats(int atacsAturats) {
		this.atacsAturats = atacsAturats;
	}
}
