package Objectes;

import java.time.LocalDate;

public class Entrenador extends PreparadorFisic {
	private int numeroTrofeus;

	public Entrenador(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email, int souBase,
			String nSS, int numeroTrofeus) {
		super(dni, nom, cognom, dataNaix, telefon, email, souBase, nSS);
		this.numeroTrofeus = numeroTrofeus;
	}

	@Override
	public String toString() {
		return super.toString() + "numeroTrofeus=" + numeroTrofeus + "]";
	}

	@Override
	public void calcularSalari() {

		this.salari = (souBase + (numeroTrofeus * 2));

	}
}
