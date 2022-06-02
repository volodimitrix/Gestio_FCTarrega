package Objectes;

import java.time.LocalDate;

public class Porter extends Jugador {
	private int golsAturats;
	private int golsRebuts;

	public Porter(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email, int souBase,
			String nSS, boolean esTitular, int golsRebuts, int atacsAturats) {
		super(dni, nom, cognom, dataNaix, telefon, email, souBase, nSS, esTitular);

		this.golsRebuts = golsRebuts;
		this.golsAturats = golsAturats;
		calcularSalari();

	}

	@Override
	public String toString() {
		return super.toString() + "golsAturats=" + golsAturats + ", golsRebuts=" + golsRebuts + "]";
	}

	@Override
	public void calcularSalari() {

		this.salari = (souBase + (golsAturats * 2));

	}

	public int getGolsAturats() {
		return golsAturats;
	}

	public void setGolsAturats(int golsAturats) {
		this.golsAturats = golsAturats;
	}

	public int getGolsRebuts() {
		return golsRebuts;
	}

	public void setGolsRebuts(int golsRebuts) {
		this.golsRebuts = golsRebuts;
	}

	@Override
	public void setGolsFets(int golsFets) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBalonsRecuperats(int balonsRecuperats) {
		// TODO Auto-generated method stub

	}
}
