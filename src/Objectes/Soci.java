package Objectes;

import java.time.LocalDate;

public class Soci extends Persona {
	private int numSoci;
	private static int numSocis;
	private static int numLocalitats = 500;
	private int numLocalitat;

	private int quotaAnual;

	public Soci(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email, int quotaAnual) {
		super(dni, nom, cognom, dataNaix, telefon, email);

		this.quotaAnual = quotaAnual;

		this.numSoci = ++numSocis;
		this.numLocalitat = ++numLocalitats;
	}

	public static int getNumSocis() {
		return numSocis;
	}

	public static void setNumSocis(int numSocis) {
		Soci.numSocis = numSocis;
	}

	@Override
	public String toString() {
		return super.toString() + " numLocalitat=" + numLocalitat + ", numSoci=" + numSoci + ", quotaAnual="
				+ quotaAnual + "]";
	}

	public int getQuotaAnual() {
		return quotaAnual;
	}

	public void setQuotaAnual(int quotaAnual) {
		this.quotaAnual = quotaAnual;
	}

	public int getNumSoci() {
		return numSoci;
	}

	public void setNumSoci(int numSoci) {
		this.numSoci = numSoci;
	}

	public static int getNumLocalitats() {
		return numLocalitats;
	}

	public static void setNumLocalitats(int numLocalitats) {
		Soci.numLocalitats = numLocalitats;
	}

	public int getNumLocalitat() {
		return numLocalitat;
	}

	public void setNumLocalitat(int numLocalitat) {
		this.numLocalitat = numLocalitat;
	}
}
