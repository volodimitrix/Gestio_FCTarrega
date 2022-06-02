package Objectes;

import java.time.LocalDate;

public class Davanter extends JugadorsBalonsRecuperats {
	private int golsFets;

	@Override
	public String toString() {
		return super.toString() + " golsFets=" + golsFets + "]";
	}

	public Davanter(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email, int souBase,
			String nSS, boolean esTitular, int balonsRecuperats, int golsFets) {
		super(dni, nom, cognom, dataNaix, telefon, email, souBase, nSS, esTitular, balonsRecuperats);
		this.golsFets = golsFets;
		calcularSalari();
	}

	@Override
	public void calcularSalari() {
		this.salari = souBase + (golsFets * 2) + (this.balonsRecuperats * 2);
	}

	public int getGolsFets() {
		return golsFets;
	}
	
	@Override
    public void setGolsFets(int golsFets) {
        this.golsFets = golsFets;
        
    }
}
