package Objectes;

import java.time.LocalDate;

public abstract class JugadorsBalonsRecuperats extends Jugador {
	protected int balonsRecuperats;

	@Override
	public String toString() {
		return super.toString() + " balonsRecuperats=" + balonsRecuperats + "";
	}

	public JugadorsBalonsRecuperats(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS, boolean esTitular, int balonsRecuperats) {
        super(dni, nom, cognom, dataNaix, telefon, email, souBase, nSS, esTitular);
        this.balonsRecuperats = balonsRecuperats;
    }

	public int getBalonsRecuperats() {
		return balonsRecuperats;
	}

	@Override
	public void setBalonsRecuperats(int balonsRecuperats) {
		this.balonsRecuperats = balonsRecuperats;
	}
}
