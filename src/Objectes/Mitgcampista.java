package Objectes;

import java.time.LocalDate;

public class Mitgcampista extends JugadorsBalonsRecuperats {
	private int asistenciesGol;

	public Mitgcampista(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS,  boolean esTitular, int balonsRecuperats,int asistenciesGol) {
        super(dni, nom, cognom, dataNaix, telefon, email,  souBase, nSS,  esTitular, balonsRecuperats);
        
        this.asistenciesGol = asistenciesGol;
        
        
        calcularSalari();
    }

	@Override
	public String toString() {
		return super.toString() + "asistenciesGol=" + asistenciesGol + "]";
	}

	@Override
	public void calcularSalari() {
		this.salari = souBase + (this.asistenciesGol * 2) + (this.balonsRecuperats * 2);

	}

	public int getAsistenciesGol() {
		return asistenciesGol;
	}

	@Override
	public void setAsistenciesGol(int asistenciesGol) {
		this.asistenciesGol = asistenciesGol;
	}

	@Override
	public void setGolsFets(int golsFets) {

	}
}
