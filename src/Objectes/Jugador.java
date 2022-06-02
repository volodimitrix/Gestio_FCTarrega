package Objectes;

import java.time.LocalDate;

public abstract class Jugador extends MembrePlantilla {

	private static int dorsals;
	private int dorsal;
	private boolean esTitular;

	@Override
	public String toString() {
		return super.toString() + ", esTitular=" + esTitular + ", dorsal=" + dorsal + "";
	}

	public Jugador(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email, int souBase,
			String nSS, boolean esTitular) {
		super(dni, nom, cognom, dataNaix, telefon, email, souBase, nSS);

		this.esTitular = esTitular;
		dorsal = ++dorsals;

	}

	public boolean isEsTitular() {
		return esTitular;
	}

	public void setEsTitular(boolean esTitular) {
		this.esTitular = esTitular;
	}

	public static int getDorsals() {
		return dorsals;
	}

	public static void setDorsals(int dorsals) {
		Jugador.dorsals = dorsals;
	}

}
