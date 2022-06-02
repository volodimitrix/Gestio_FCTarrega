package Objectes;

import java.time.LocalDate;

public abstract  class MembrePlantilla extends Persona {
	protected int souBase;
	private String NSS;

	private int numeroEmpleat;
	private static int numeroEmpleats;
	protected int salari;

	abstract public void calcularSalari();

	@Override
	public String toString() {
		return super.toString() + "NSS=" + NSS + ", salari=" + salari + ", souBase=" + souBase + " numeroEmpleat "
				+ numeroEmpleat + " ";
	}

	public MembrePlantilla(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
			int souBase, String nSS) {
		super(dni, nom, cognom, dataNaix, telefon, email);
		this.souBase = souBase;
		NSS = nSS;
		this.numeroEmpleat = ++numeroEmpleats;
	}

	public int getSouBase() {
		return souBase;
	}

	public void setSouBase(int souBase) {
		this.souBase = souBase;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}

	public int getSalari() {
		return salari;
	}

	public void setSalari(int salari) {
		this.salari = salari;
	}

	public static int getNumeroEmpleats() {
		return numeroEmpleats;
	}

	public static void setNumeroEmpleats(int numeroEmpleats) {
		MembrePlantilla.numeroEmpleats = numeroEmpleats;
	}

	abstract public void setGolsFets(int golsFets);

	abstract public void setBalonsRecuperats(int balonsRecuperats);

	public void setAsistenciesGol(int asistenciesGol) {
	}

	public void setAtacsAturats(int atacsAturats) {
	}

	public void setGolsAturats(int golsAturats) {
	}

	public void setGolsRebuts(int golsRebuts) {
	}

}
