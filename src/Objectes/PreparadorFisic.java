package Objectes;

import java.time.LocalDate;
import java.time.Period;

public class PreparadorFisic extends MembrePlantilla {
	private LocalDate diaFitxa;
	private int anysExperiencia;

	public PreparadorFisic(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
			int souBase, String nSS) {
		super(dni, nom, cognom, dataNaix, telefon, email, souBase, nSS);

		this.diaFitxa = diaFitxa;

		anysExperiencia = Period.between(diaFitxa, LocalDate.now()).getYears();

		calcularSalari();
	}

	@Override
	public String toString() {
		return super.toString() + "anysExperiencia=" + anysExperiencia + ", diaFitxa=" + diaFitxa + "]";
	}

	@Override
	public void calcularSalari() {

		this.salari = (souBase + (anysExperiencia * 2));

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
