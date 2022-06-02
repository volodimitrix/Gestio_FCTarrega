package Menu;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import Objectes.Davanter;
import Objectes.Defensa;
import Objectes.Entrenador;
import Objectes.Jugador;
import Objectes.MembrePlantilla;
import Objectes.Mitgcampista;
import Objectes.Porter;
import Objectes.PreparadorFisic;
import Objectes.Soci;

public class Club {
	private String nom = "FCTàrrega";
	private String dni = "55263603P";
	private String adreca = "Aviguda de l'Ondara";
	private int telefon = 123456789;
	private String email = "volo@gmail.com";
	private String web = "www.google.es";

	private boolean sortir = false;

	Scanner scanner = new Scanner(System.in);

	private HashMap<String, MembrePlantilla> membresPlantilla = new HashMap<>();
	private HashMap<String, Soci> socis = new HashMap<>();

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Club FCTarrega = new Club();
		FCTarrega.gestioFutbolClub();
	}

	public Club() {

	}

	public void gestioFutbolClub() throws IOException {
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Consultar dades del club.");
			System.out.println("2. Gestionar els socis.");
			System.out.println("3. Gestionar la plantilla");
			System.out.println("4. Visualitzar les dades econòmiques.");
			System.out.println("5. Sortir");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				System.out.println(toString());
				sortir = false;
				break;

			case '2':
				gestionarSocis();
				sortir = false;
				break;

			case '3':
				gestionarPlantilla();
				sortir = false;
				break;

			case '4':
				mostrarDadesEconomiques();
				sortir = false;
				break;

			case '5':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");
			}
		} while (!sortir);
	}

	public void gestionarSocis() {
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Donar alta a un soci.");
			System.out.println("2. Donar de baixa un soci.");
			System.out.println("3. Modificar un soci.");
			System.out.println("4. Mostrar tots els socis ordenats.");
			System.out.println("5. Sortir");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				donarAltaSoci();
				sortir = false;
				break;

			case '2':
				donarBaixaSoci();
				sortir = false;
				break;

			case '3':
				modificarSoci();
				sortir = false;
				break;

			case '4':
				mostrarSocis();
				sortir = false;
				break;

			case '5':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");
			}
		} while (!sortir);
	}
	
	public void donarAltaSoci() {
		System.out.println("========= DONAR D'ALTA SOCI =========");
		System.out.println("Insereix el DNI: ");
		String dni = scanner.nextLine();
		System.out.println("Insereix el nom: ");
		String nom = scanner.nextLine();
		System.out.println("Insereix el cognom: ");
		String cognom = scanner.nextLine();
		System.out.println("Insereix la seva data de naixament: ");
		String data = scanner.nextLine();
		System.out.println("Insereix el número de telefon: ");
		int telefon = scanner.nextInt();
		System.out.println("Insereix el correu: ");
		String correu = scanner.nextLine();
		System.out.println("Insereix la quota: ");
        int quotaAnual = scanner.nextInt();
        
        socis.put(dni, new Soci(dni, nom, cognom, LocalDate.parse(data), telefon, correu, quotaAnual));
	}

	public void gestionarPlantilla() {
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Gestionar entrenadors.");
			System.out.println("2. Gestionar preparadors fisics.");
			System.out.println("3. Gestionar porters.");
			System.out.println("4. Gestionar defenses.");
			System.out.println("5. Gestionar migcampistes.");
			System.out.println("6. Gestionar davanters.");
			System.out.println("7. Mostrar els treballadors.");
			System.out.println("8. Sortir.");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				gestionarEntrenadors();
				sortir = false;
				break;

			case '2':
				gestionarPreparadors();
				sortir = false;
				break;

			case '3':
				gestionarPorters();
				sortir = false;
				break;

			case '4':
				gestionarDefenses();
				sortir = false;
				break;

			case '5':
				gestionarMigcampistes();
				sortir = false;
				break;

			case '6':
				gestionarDavanters();
				sortir = false;
				break;

			case '7':
				mostrarTreballadors();
				sortir = false;
				break;

			case '8':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");

			}
		} while (!sortir);
	}
	
	public void mostrarDadesEconomiques() {
		System.out.println("========= DADES ECONÓMIQUES ==========");

        int presupostSocis = 0;
        int presupostMembresPlantilla = 0;

        for (Soci sc : socis.values()) {

            presupostSocis = presupostSocis + sc.getQuotaAnual();
        }

        for (MembrePlantilla mp : membresPlantilla.values()) {

            presupostMembresPlantilla = presupostMembresPlantilla + mp.getSalari();
        }

        System.out.println("Ingressos bruts: " + presupostSocis);
        System.out.println("Salari global: " + presupostMembresPlantilla);

        System.out.println("Ingressos nets: " + (presupostSocis - presupostMembresPlantilla));
	}
	
	public void mostrarMembresPlantilla() {

        for (MembrePlantilla MP : membresPlantilla.values()) {

            System.out.println(MP);
        }
    }
	
	private void gestionarEntrenadors() {
		do {
			System.out.println("========= FC TÀRREGA ==========");
            System.out.println("1. Donar d'alta a entrenadors.");
            System.out.println("2. Donar de baixa a entrenadors.");
            System.out.println("3. Modificar entrenadors.");
            System.out.println("4. Sortir");
            System.out.println("================================");
            
            String si = scanner.next();
			char opcio = si.charAt(0);
			
			switch (opcio) {
				case '1':
					donarAltaEntrenadors();
                    sortir = false;
                    break;
					
				case '2':
					donarBaixaTreballador();
                    sortir = false;
                    break;
					
				case '3':
					modificarEntrenadors();
	                sortir = false;
	                break;
					
				case '4':
					System.out.println("Sortir.");
					sortir = true;
					break;

				default:
					System.out.println("Opció no vàlida.");
			}
		}
		while (!sortir);
	}
	
	private void donarAltaEntrenadors() {
		System.out.println("========= DONAR D'ALTA ENTRENADOR =========");
		System.out.println("Insereix el DNI: ");
		String dni = scanner.nextLine();
		System.out.println("Insereix el nom: ");
		String nom = scanner.nextLine();
		System.out.println("Insereix el cognom: ");
		String cognom = scanner.nextLine();
		System.out.println("Insereix la seva data de naixament: ");
		String data = scanner.nextLine();
		System.out.println("Insereix el número de telefon: ");
		int telefon = scanner.nextInt();
		System.out.println("Insereix el correu: ");
		String correu = scanner.nextLine();
		System.out.println("Insereix el salari: ");
		int salari = scanner.nextInt();
		System.out.println("Insereix el NSS: ");
		String NSS = scanner.nextLine();
		System.out.println("Insereix el nº de trofeus: ");
        int numtrofeus = scanner.nextInt();
        
        membresPlantilla.put(dni,
                new Entrenador(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari, NSS, numtrofeus));
	}
	
	private void modificarEntrenadors() {
		System.out.println("Insereix el DNI del entrenador que vols modificar: ");
		scanner.nextLine();
		String dni = scanner.nextLine();
		
		try {
			System.out.println(membresPlantilla.get(dni).toString());
			
			do {
				System.out.println("========= FC TÀRREGA ==========");
				System.out.println("1. Modificar nom del entrenador.");
                System.out.println("2. Modificar cognom del entrenador.");
                System.out.println("3. Modificar telefon del entrenador.");
                System.out.println("4. Modificar l'email del entrenador.");
                System.out.println("5. Modificar quota anual del entrenador.");
                System.out.println("6. Modificar NSS del entrenador.");
                System.out.println("7. Sortir");
				System.out.println("================================");
				
				String si = scanner.next();
				char opcio = si.charAt(0);
				
				switch (opcio) {
					case '1':
						System.out.println("Insereix el nom: ");
                        scanner.nextLine();
                        String nom = scanner.nextLine();
                        membresPlantilla.get(dni).setNom(nom);
                        sortir = false;
                        break;
						
					case '2':
						System.out.println("Insereix el cognom: ");
                        scanner.nextLine();
                        String cognom = scanner.nextLine();
                        membresPlantilla.get(dni).setCognom(cognom);
                        sortir = false;
                        break;
						
					case '3':
						System.out.println("Insereix el telefon: ");
	                    scanner.nextLine();
	                    int telefon = scanner.nextInt();
	                    membresPlantilla.get(dni).setTelefon(telefon);
	                    sortir = false;
	                    break;
						
					case '4':
						System.out.println("Insereix l'email: ");
                        scanner.nextLine();
                        String email = scanner.nextLine();
                        membresPlantilla.get(dni).setEmail(email);
                        sortir = false;
                        break;
						
					case '5':
						System.out.println("Insereix la quota anual: ");
                        scanner.nextLine();
                        int quotaAnual = scanner.nextInt();
                        membresPlantilla.get(dni).setSouBase(quotaAnual);
                        sortir = false;
                        break;
						
					case '6':
						System.out.println("Insereix el NSS: ");
                        scanner.nextLine();
                        String nss = scanner.nextLine();
                        membresPlantilla.get(dni).setNSS(nss);
                        sortir = false;
                        break;
						
					case '7':
						System.out.println("Sortir.");
						sortir = true;
						break;

					default:
						System.out.println("Opció no vàlida.");	
				}
			}
			while (!sortir);
		}
		catch (Exception e) {
			System.out.println("Aquest DNI no existeix.");
		}
	}
	
	@Override
    public String toString() {
        return "ClubFutbol [DNI = " + dni + ", adreça = " + adreca + ", email = " + email + ", nom = " + nom + ", telefon = "
                + telefon + ", web = " + web + "]";
    }

	private void gestionarPreparadors() {
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Donar d'alta preparadors.");
			System.out.println("2. Donar de baixa a preparadors.");
			System.out.println("3. Modificar preparadors.");
			System.out.println("4. Sortir.");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				altaPreparadors();
				sortir = false;
				break;
				
			case '2':
				donarBaixaTreballador();
				sortir = false;
				break;
				
			case '3':
				modificarPreparadors();
				sortir = false;
				break;
				
			case '4':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");
			}
		}
		while (!sortir);
	}
	
	private void altaPreparadors() {
		System.out.println("========= DONAR D'ALTA PREPARADOR ========="); 
		System.out.println("Insereix el DNI: ");
		String dni = scanner.nextLine();
		System.out.println("Insereix el nom: ");
		String nom = scanner.nextLine();
		System.out.println("Insereix el cognom: ");
		String cognom = scanner.nextLine();
		System.out.println("Insereix la seva data de naixament: ");
		String data = scanner.nextLine();
		System.out.println("Insereix el número de telefon: ");
		int telefon = scanner.nextInt();
		System.out.println("Insereix el correu: ");
		String correu = scanner.nextLine();
		System.out.println("Insereix el salari: ");
		int salari = scanner.nextInt();
		System.out.println("Insereix el NSS: ");
		String NSS = scanner.nextLine();
		
		membresPlantilla.put(dni, new PreparadorFisic(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari,
                NSS));
	}
	
	private void modificarPreparadors() {
		System.out.println("Insereix el DNI del preparador que vols modificar: ");
		scanner.nextLine();
		String dni = scanner.nextLine();
		
		try {
			System.out.println(membresPlantilla.get(dni).toString());
			
			do {
				System.out.println("========= FC TÀRREGA ==========");
				System.out.println("1. Modificar nom del preparador.");
                System.out.println("2. Modificar cognom del preparador.");
                System.out.println("3. Modificar telefon del preparador");
                System.out.println("4. Modificar email dels preparador.");
                System.out.println("5. Modificar quota anual del prepador.");
                System.out.println("6. Modificar NSS del preparador.");
                System.out.println("7. Sortir");
				System.out.println("================================");
				
				String si = scanner.next();
				char opcio = si.charAt(0);
				
				switch (opcio) {
					case '1':
						System.out.println("Insereix el nom: ");
                        scanner.nextLine();
                        String nom = scanner.nextLine();
                        membresPlantilla.get(dni).setNom(nom);
                        sortir = false;
                        break;
						
					case '2':
						System.out.println("Insereix el cognom: ");
                        scanner.nextLine();
                        String cognom = scanner.nextLine();
                        membresPlantilla.get(dni).setCognom(cognom);
                        sortir = false;
                        break;
						
					case '3':
						System.out.println("Insereix el telefon: ");
                        scanner.nextLine();
                        int telefon = scanner.nextInt();
                        membresPlantilla.get(dni).setTelefon(telefon);
                        sortir = false;
                        break;
						
					case '4':
						System.out.println("Insereix l'email: ");
                        scanner.nextLine();
                        String email = scanner.nextLine();
                        membresPlantilla.get(dni).setEmail(email);
                        sortir = false;
                        break;
						
					case '5':
						System.out.println("Insereix la quota anual: ");
                        scanner.nextLine();
                        int quotaAnual = scanner.nextInt();
                        membresPlantilla.get(dni).setSouBase(quotaAnual);
                        sortir = false;
                        break;
						
					case '6':
						System.out.println("Insereix el NSS: ");
                        scanner.nextLine();
                        String nss = scanner.nextLine();
                        membresPlantilla.get(dni).setNSS(nss);
                        sortir = false;
                        break;
						
					case '7':
						System.out.println("Sortir.");
						sortir = true;
						break;

					default:
						System.out.println("Opció no vàlida.");	
				}
			}
			while (!sortir);
		}
		catch (Exception e) {
			System.out.println("Aquest DNI no existeix.");
		}
	}

	private void gestionarPorters() {
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Donar d'alta porter.");
			System.out.println("2. Donar de baixa a porters.");
			System.out.println("3. Modificar porters.");
			System.out.println("4. Sortir.");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				donarAltaPorters();
				sortir = false;
				break;

			case '2':
				donarBaixaTreballador();
				sortir = false;
				break;

			case '3':
				modificarPorters();
				sortir = false;
				break;

			case '4':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");
			}
		} while (!sortir);
	}

	private void donarAltaPorters() {
		System.out.println("========= DONAR D'ALTA PORTER =========");
		System.out.println("Insereix el DNI: ");
		String dni = scanner.nextLine();
		System.out.println("Insereix el nom: ");
		String nom = scanner.nextLine();
		System.out.println("Insereix el cognom: ");
		String cognom = scanner.nextLine();
		System.out.println("Insereix la seva data de naixament: ");
		String data = scanner.nextLine();
		System.out.println("Insereix el número de telefon: ");
		int telefon = scanner.nextInt();
		System.out.println("Insereix el correu: ");
		String correu = scanner.nextLine();
		System.out.println("Insereix el salari: ");
		int salari = scanner.nextInt();
		System.out.println("Insereix el NSS: ");
		String NSS = scanner.nextLine();
		System.out.println("Es titular? Si o No.");
        boolean titular = false;
		String opcio = scanner.nextLine();
		if (opcio.equals("Si") || opcio.equals("si")) {
			titular = true;
		} else {
			titular = false;
		}

		System.out.println("Insereix el nº de gols aturats: ");
		int golsAturats = scanner.nextInt();
		System.out.println("Insereix ek nº de gols rebuts:");
		int golsRebuts = scanner.nextInt();

		membresPlantilla.put(dni, new Porter(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari, NSS,
				titular, golsAturats, golsRebuts));
	}

	private void modificarPorters() {
		System.out.println("Insereix el DNI del porter que vols modificar: ");
		scanner.nextLine();
		String dni = scanner.nextLine();

		try {
			System.out.println(membresPlantilla.get(dni).toString());

			do {
				System.out.println("========= FC TÀRREGA ==========");
				System.out.println("1. Modificar nom del porter: ");
				System.out.println("2. Modificar cognom del porter: ");
				System.out.println("3. Modificar telefon del porter: ");
				System.out.println("4. Modificar email del porter: ");
				System.out.println("5. Modificar quota anual del porter: ");
				System.out.println("6. Modificar NSS del porter: ");
				System.out.println("7. Balons recuperats:");
				System.out.println("8. Atacs aturats:");
				System.out.println("9. Sortir");
				System.out.println("================================");

				String si = scanner.next();
				char opcio = si.charAt(0);

				switch (opcio) {
				case '1':
					System.out.println("Insereix el nom:");
					scanner.nextLine();
					String nom = scanner.nextLine();
					membresPlantilla.get(dni).setNom(nom);
					sortir = false;
					break;

				case '2':
					System.out.println("Insereix el cognom:");
					scanner.nextLine();
					String cognom = scanner.nextLine();
					membresPlantilla.get(dni).setCognom(cognom);
					sortir = false;
					break;

				case '3':
					System.out.println("Insereix el telefon:");
					scanner.nextLine();
					int telefon = scanner.nextInt();
					membresPlantilla.get(dni).setTelefon(telefon);
					sortir = false;
					break;

				case '4':
					System.out.println("Insereix l'email:");
					scanner.nextLine();
					String email = scanner.nextLine();
					membresPlantilla.get(dni).setEmail(email);
					sortir = false;
					break;

				case '5':
					System.out.println("Insereix la quota anual:");
					scanner.nextLine();
					int quotaAnual = scanner.nextInt();
					membresPlantilla.get(dni).setSouBase(quotaAnual);
					sortir = false;
					break;

				case '6':
					System.out.println("Insereix el NSS:");
					scanner.nextLine();
					String nss = scanner.nextLine();
					membresPlantilla.get(dni).setNSS(nss);
					sortir = false;
					break;

				case '7':
					System.out.println("Inserta el nº de gols aturats:");
					scanner.nextLine();
					int golsAturats = scanner.nextInt();
					membresPlantilla.get(dni).setGolsAturats(golsAturats);
					sortir = false;
					break;

				case '8':
					System.out.println("Inserta el nº de gols rebuts:");
					scanner.nextLine();
					int golsRebuts = scanner.nextInt();
					membresPlantilla.get(dni).setGolsRebuts(golsRebuts);
					sortir = false;
					break;

				case '9':
					System.out.println("Sortir.");
					sortir = true;
					break;

				default:
					System.out.println("Opció no vàlida.");
				}
			} while (!sortir);
		} catch (Exception e) {
			System.out.println("Aquest DNI no existeix.");
		}
	}

	private void gestionarDefenses() {
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Donar d'alta defensa.");
			System.out.println("2. Donar de baixa a defensa.");
			System.out.println("3. Modificar Defensa.");
			System.out.println("4. Sortir.");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				donarAltaDefensa();
				sortir = false;
				break;

			case '2':
				donarBaixaTreballador();
				sortir = false;
				break;

			case '3':
				modificarDefensa();
				sortir = false;
				break;

			case '4':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");
			}
		} while (!sortir);
	}

	private void donarAltaDefensa() {
		System.out.println("========= DONAR D'ALTA DEFENSA =========");
		System.out.println("Insereix el DNI: ");
		String dni = scanner.nextLine();
		System.out.println("Insereix el nom: ");
		String nom = scanner.nextLine();
		System.out.println("Insereix el cognom: ");
		String cognom = scanner.nextLine();
		System.out.println("Insereix la seva data de naixament: ");
		String data = scanner.nextLine();
		System.out.println("Insereix el número de telefon: ");
		int telefon = scanner.nextInt();
		System.out.println("Insereix el correu: ");
		String correu = scanner.nextLine();
		System.out.println("Insereix el salari: ");
		int salari = scanner.nextInt();
		System.out.println("Insereix el NSS: ");
		String NSS = scanner.nextLine();
		System.out.println("Insereix el nº de balons recuperats: ");
		int balonsRecuperats = scanner.nextInt();
		System.out.println("Insereix els atacs aturats: ");
		int atacsAturats = scanner.nextInt();

		System.out.println("Es titular? Si o No.");
		boolean titular = false;
		String opcio = scanner.nextLine();

		if (opcio.equals("Si") || opcio.equals("si")) {
			titular = true;
		}

		membresPlantilla.put(dni, new Defensa(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari, NSS,
				titular, balonsRecuperats, atacsAturats));
	}

	private void modificarDefensa() {
		System.out.println("Insereix el DNI del defensa que vols modificar: ");
		scanner.nextLine();
		String dni = scanner.nextLine();

		try {
			System.out.println(membresPlantilla.get(dni).toString());

			do {
				System.out.println("========= FC TÀRREGA ==========");
				System.out.println("1. Modificar nom de defensa: ");
				System.out.println("2. Modificar cognom de defensa: ");
				System.out.println("3. Modificar telefon de defensa: ");
				System.out.println("4. Modificar email de defensa: ");
				System.out.println("5. Modificar quota anual de defensa: ");
				System.out.println("6. Modificar NSS de defensa: ");
				System.out.println("7. Balons recuperats de defensa: ");
				System.out.println("8. Atacs aturats de defensa: ");
				System.out.println("9. Sortir");
				System.out.println("================================");

				String si = scanner.next();
				char opcio = si.charAt(0);

				switch (opcio) {
				case '1':
					System.out.println("Insereix el nom: ");
					scanner.nextLine();
					String nom = scanner.nextLine();
					membresPlantilla.get(dni).setNom(nom);
					sortir = false;
					break;

				case '2':
					System.out.println("Insereix el cognom: ");
					scanner.nextLine();
					String cognom = scanner.nextLine();
					membresPlantilla.get(dni).setCognom(cognom);
					sortir = false;
					break;

				case '3':
					System.out.println("Insereix el telefon: ");
					scanner.nextLine();
					int telefon = scanner.nextInt();
					membresPlantilla.get(dni).setTelefon(telefon);
					sortir = false;
					break;

				case '4':
					System.out.println("Insereix el Email: ");
					scanner.nextLine();
					String email = scanner.nextLine();
					membresPlantilla.get(dni).setEmail(email);
					sortir = false;
					break;

				case '5':
					System.out.println("Insereix la quota anual: ");
					scanner.nextLine();
					int quotaAnual = scanner.nextInt();
					membresPlantilla.get(dni).setSouBase(quotaAnual);
					sortir = false;
					break;

				case '6':
					System.out.println("Insereix el NSS: ");
					scanner.nextLine();
					String nss = scanner.nextLine();
					membresPlantilla.get(dni).setNSS(nss);
					sortir = false;
					break;

				case '7':
					System.out.println("Insereix en nº de balons recuperats:");
					scanner.nextLine();
					int balonsRecuperats = scanner.nextInt();
					membresPlantilla.get(dni).setBalonsRecuperats(balonsRecuperats);
					sortir = false;
					break;

				case '8':
					System.out.println("Insereix els atacs aturats: ");
					scanner.nextLine();
					int atacsAturats = scanner.nextInt();
					membresPlantilla.get(dni).setAtacsAturats(atacsAturats);
					sortir = false;
					break;

				case '9':
					System.out.println("Sortir.");
					sortir = true;
					break;

				default:
					System.out.println("Opció no vàlida.");
				}
			} while (!sortir);
		} catch (Exception e) {
			System.out.println("Aquest DNI no existeix.");
		}
	}

	private void gestionarMigcampistes() {
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Donar d'alta a MigCampista");
			System.out.println("2. Donar baixa a MigCampista");
			System.out.println("3. Modificar MigCampista");
			System.out.println("4. Sortir.");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				donarAltaMigCampista();
				sortir = false;
				break;

			case '2':
				donarBaixaTreballador();
				sortir = false;
				break;

			case '3':
				modificarMigCampista();
				sortir = false;
				break;

			case '4':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");
			}
		} while (!sortir);
	}

	private void donarAltaMigCampista() {
		System.out.println("========= DONAR D'ALTA AL MITGCAMPISTA =========");
		System.out.println("Insereix el DNI: ");
		String dni = scanner.nextLine();
		System.out.println("Insereix el nom: ");
		String nom = scanner.nextLine();
		System.out.println("Insereix el cognom: ");
		String cognom = scanner.nextLine();
		System.out.println("Insereix la seva data de naixament: ");
		String data = scanner.nextLine();
		System.out.println("Insereix el número de telefon: ");
		int telefon = scanner.nextInt();
		System.out.println("Insereix el correu: ");
		String correu = scanner.nextLine();
		System.out.println("Insereix el salari: ");
		int salari = scanner.nextInt();
		System.out.println("Insereix el NSS: ");
		String NSS = scanner.nextLine();
		System.out.println("Insereix el nº de balons recuperats: ");
		int balonsRecuperats = scanner.nextInt();
		System.out.println("Insereix les asistencies gol: ");
		int asistenciesGol = scanner.nextInt();

		System.out.println("Es titular? Si o No.");
		boolean titular = false;
		String opcio = scanner.nextLine();

		if (opcio.equals("Si") || opcio.equals("si")) {
			titular = true;
		}

		membresPlantilla.put(dni, new Mitgcampista(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari, NSS,
				titular, balonsRecuperats, asistenciesGol));
	}

	private void donarBaixaTreballador() {
		System.out.println("Insereix el DNI del treballador que vols donar de baixa: ");

		scanner.nextLine();
		String dni = scanner.nextLine();

		try {
			System.out.println("El treballador amb el DNI: " + membresPlantilla.get(dni).toString() + " s'ha donat de baixa correctament.");
			membresPlantilla.remove(dni);
		} catch (NullPointerException e) {
			System.out.println("Aquest DNI no existeix.");
		}
	}

	private void modificarMigCampista() {
		System.out.println("Insereix el DNI del mitgcampista que vols modificar: ");
		scanner.nextLine();
		String dni = scanner.nextLine();

		try {
			System.out.println(membresPlantilla.get(dni).toString());

			do {
				System.out.println("========= FC TÀRREGA ==========");
				System.out.println("1. Modificar el nom del mitgcampista.");
				System.out.println("2. Modificar el cognom del mitgcampista.");
				System.out.println("3. Modificar el telefon del mitgcampista.");
				System.out.println("4. Modificar el email del mitgcampista.");
				System.out.println("5. Modificar la quota anual del mitgcampista.");
				System.out.println("6. Modificar NSS del mitgcampista");
				System.out.println("7. Balons recuperats:");
				System.out.println("8. Assistencies Gol:");
				System.out.println("9. Sortir");
				System.out.println("================================");

				String si = scanner.next();
				char opcio = si.charAt(0);

				switch (opcio) {
				case '1':
					System.out.println("Insereix el nom:");
					scanner.nextLine();
					String nom = scanner.nextLine();
					membresPlantilla.get(dni).setNom(nom);
					sortir = false;
					break;

				case '2':
					System.out.println("Insereix el cognom:");
					scanner.nextLine();
					String cognom = scanner.nextLine();
					membresPlantilla.get(dni).setCognom(cognom);
					sortir = false;
					break;

				case '3':
					System.out.println("Insereix el telefon:");
					scanner.nextLine();
					int telefon = scanner.nextInt();
					membresPlantilla.get(dni).setTelefon(telefon);
					sortir = false;
					break;

				case '4':
					System.out.println("Insereix l'email:");
					scanner.nextLine();
					String email = scanner.nextLine();
					membresPlantilla.get(dni).setEmail(email);
					sortir = false;
					break;

				case '5':
					System.out.println("Insereix la quota anual:");
					scanner.nextLine();
					int quotaAnual = scanner.nextInt();
					membresPlantilla.get(dni).setSouBase(quotaAnual);
					sortir = false;
					break;

				case '6':
					System.out.println("Insereix el NSS:");
					scanner.nextLine();
					String nss = scanner.nextLine();
					membresPlantilla.get(dni).setNSS(nss);
					sortir = false;
					break;

				case '7':
					System.out.println("Insereix el nº de balons recuperats:");
					scanner.nextLine();
					int balonsRecuperats = scanner.nextInt();
					membresPlantilla.get(dni).setBalonsRecuperats(balonsRecuperats);
					sortir = false;
					break;

				case '8':
					System.out.println("Insereix les assistencies de gols:");
					scanner.nextLine();
					int asistenciesGol = scanner.nextInt();
					membresPlantilla.get(dni).setAsistenciesGol(asistenciesGol);
					sortir = false;
					break;

				case '9':
					System.out.println("Sortir.");
					sortir = true;
					break;

				default:
					System.out.println("Opcio no valida");

				}
			} while (!sortir);
		} catch (Exception e) {
			System.out.println("Aquest DNI no existeix.");
		}
	}

	private void gestionarDavanters() {
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Donar d'alta al davanter.");
			System.out.println("2. Donar de baixa al davanter.");
			System.out.println("3. Modificar Davanter.");
			System.out.println("4. Sortir");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				donarAltaDavanter();
				sortir = false;
				break;

			case '2':
				donarBaixaTreballador();
				sortir = false;
				break;

			case '3':
				modificarDavanter();
				sortir = false;
				break;

			case '4':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");
			}
		} while (!sortir);
	}
	
	public void donarAltaDavanter() {
		System.out.println("========= DONAR D'ALTA AL DAVANTER =========");
		System.out.println("Insereix el DNI: ");
		String dni = scanner.nextLine();
		System.out.println("Insereix el nom: ");
		String nom = scanner.nextLine();
		System.out.println("Insereix el cognom: ");
		String cognom = scanner.nextLine();
		System.out.println("Insereix la seva data de naixament: ");
		String data = scanner.nextLine();
		System.out.println("Insereix el número de telefon: ");
		int telefon = scanner.nextInt();
		System.out.println("Insereix el correu: ");
		String correu = scanner.nextLine();
		System.out.println("Insereix el salari: ");
		int salari = scanner.nextInt();
		System.out.println("Insereix el NSS: ");
		String NSS = scanner.nextLine();
		System.out.println("Es titular? Si o No.");
        boolean titular = false;
        String opcio = scanner.nextLine();
        if (opcio.equals("Si") || opcio.equals("si")) {
            titular = true;
        } else {
            titular = false;
        }
        System.out.println("Inserta el nº de balons recuperats: ");
        int balonsRecuperats = scanner.nextInt();
        System.out.println("Inserta el nº de atacs aturats: ");
        int atacsAturats = scanner.nextInt();
        
        membresPlantilla.put(dni, new Davanter(dni, nom, cognom, LocalDate.parse(data), telefon,
                correu, salari, NSS, titular, balonsRecuperats, atacsAturats));
	}

	private void mostrarTreballadors() {
		ArrayList<MembrePlantilla> membresPlantillaList = new ArrayList<MembrePlantilla>();

		for (MembrePlantilla membre : membresPlantilla.values()) {
			membresPlantillaList.add(membre);
		}

		Collections.sort(membresPlantillaList, new Comparator<MembrePlantilla>() {
			public int compare(MembrePlantilla v1, MembrePlantilla v2) {
				int result = v1.getClass().getSimpleName().compareTo(v2.getClass().getSimpleName());
				return result;
			}
		});

		for (MembrePlantilla membre : membresPlantillaList) {

			System.out.println(membre);
		}
	}

	private void modificarDavanter() {
		System.out.println("Insereix el DNI del davanter per modificar:");
		scanner.nextLine();
		String dni = scanner.nextLine();

		try {
			System.out.println(membresPlantilla.get(dni).toString());

			do {
				System.out.println("========= FC TÀRREGA ==========");
				System.out.println("1. Modificar nom de davanter.");
				System.out.println("2. Modificar cognom de davanter.");
				System.out.println("3. Modificar telefon de davanter.");
				System.out.println("4. Modificar email de davanter.");
				System.out.println("5. Modificar quota anual de davaner.");
				System.out.println("6. Modificar NSS de davaner.");
				System.out.println("7. Gols marcats.");
				System.out.println("8. Balons recuperats.");
				System.out.println("9. Sortir");
				System.out.println("================================");

				String si = scanner.next();
				char opcio = si.charAt(0);

				switch (opcio) {
				case '1':
					System.out.println("Insereix el nom:");
					scanner.nextLine();
					String nom = scanner.nextLine();
					membresPlantilla.get(dni).setNom(nom);
					sortir = false;
					break;

				case '2':
					System.out.println("Insereix el cognom:");
					scanner.nextLine();
					String cognom = scanner.nextLine();
					membresPlantilla.get(dni).setCognom(cognom);
					sortir = false;
					break;

				case '3':
					System.out.println("Insereix el telefon:");
					scanner.nextLine();
					int telefon = scanner.nextInt();
					membresPlantilla.get(dni).setTelefon(telefon);
					sortir = false;
					break;

				case '4':
					System.out.println("Insereix el Email:");
					scanner.nextLine();
					String email = scanner.nextLine();
					membresPlantilla.get(dni).setEmail(email);
					sortir = false;
					break;

				case '5':
					System.out.println("Insereix la quota anual:");
					scanner.nextLine();
					int quotaAnual = scanner.nextInt();
					membresPlantilla.get(dni).setTelefon(quotaAnual);
					sortir = false;
					break;

				case '6':
					System.out.println("Insereix el NSS:");
					scanner.nextLine();
					String nss = scanner.nextLine();
					membresPlantilla.get(dni).setNSS(nss);
					sortir = false;
					break;

				case '7':
					System.out.println("Insereix el nº de Gols Marcats:");
					scanner.nextLine();
					int golsMarcats = scanner.nextInt();
					membresPlantilla.get(dni).setGolsFets(golsMarcats);
					sortir = false;
					break;

				case '8':
					System.out.println("Insereix el nº de balons recuperats:");
					scanner.nextLine();
					int balonsRecuperats = scanner.nextInt();
					membresPlantilla.get(dni).setBalonsRecuperats(balonsRecuperats);
					sortir = false;
					break;

				case '9':
					System.out.println("Sortir.");
					membresPlantilla.get(dni).calcularSalari();
					sortir = true;
					break;

				default:
					System.out.println("Opció no vàlida.");
				}
			} while (!sortir);
		} catch (Exception e) {
			System.out.println("Aquest dni no existeix.");
		}
	}

	private void donarBaixaSoci() {

		System.out.println("Insereix el DNI que vulguis eliminar.");

		scanner.nextLine();
		String dni = scanner.nextLine();
		try {
			System.out.println("El soci amb el DNI " + socis.get(dni).toString() + " s'ha eliminar correctment.");
			socis.remove(dni);
		} catch (NullPointerException e) {
			System.out.println("Aquet dni no existeix");
		}

	}

	private void modificarSoci() {
		System.out.println("Insereix el DNI:");
		scanner.nextLine();
		String dni = scanner.nextLine();

		try {
			System.out.println(socis.get(dni).toString());

			do {
				System.out.println("========= FC TÀRREGA ==========");
				System.out.println("1. Modificar Nom.");
				System.out.println("2. Modificar Cognom.");
				System.out.println("3. Modificar Telefon.");
				System.out.println("4. Modificar Email.");
				System.out.println("5. Modificar Quaota Anual.");
				System.out.println("6. Sortir.");
				System.out.println("================================");

				String si = scanner.next();
				char opcio = si.charAt(0);

				switch (opcio) {
				case '1':
					System.out.println("Insereix el nom:");
					scanner.nextLine();
					String nom = scanner.nextLine();
					socis.get(dni).setNom(nom);
					sortir = false;
					break;

				case '2':
					System.out.println("Insereix el cognom:");
					scanner.nextLine();
					String cognom = scanner.nextLine();
					socis.get(dni).setCognom(cognom);
					sortir = false;
					break;

				case '3':
					System.out.println("Insereix el número de telèfon:");
					scanner.nextLine();
					int telefon = scanner.nextInt();
					socis.get(dni).setTelefon(telefon);
					sortir = false;
					break;

				case '4':
					System.out.println("Insereix l'email:");
					scanner.nextLine();
					String email = scanner.nextLine();
					socis.get(dni).setEmail(email);
					sortir = false;
					break;

				case '5':
					System.out.println("Insereix la quota anual:");
					scanner.nextLine();
					int quotaAnual = scanner.nextInt();
					socis.get(dni).setQuotaAnual(quotaAnual);
					sortir = false;
					break;

				case '6':
					System.out.println("Sortir.");
					sortir = true;
					break;

				default:
					System.out.println("Opció no vàlida.");
				}
			} while (!sortir);
		} catch (Exception e) {
			System.out.println("Aquest DNI no existeix.");
		}

	}

	private void mostrarSocis() {
		System.out.println("Com vols ordenar els socis?");
		do {
			System.out.println("========= FC TÀRREGA ==========");
			System.out.println("1. Per noms i cognoms.");
			System.out.println("2. Per localitat.");
			System.out.println("3. Per quota.");
			System.out.println("4. Sortir");
			System.out.println("================================");

			String si = scanner.next();
			char opcio = si.charAt(0);

			switch (opcio) {
			case '1':
				ordenarPerNomCognom();
				sortir = false;
				break;

			case '2':
				ordenarPerLocalitat();
				sortir = false;
				break;

			case '3':
				ordenarPerQuota();
				sortir = false;
				break;

			case '4':
				System.out.println("Sortir.");
				sortir = true;
				break;

			default:
				System.out.println("Opció no vàlida.");
			}
		} while (!sortir);
	}

	private void ordenarPerNomCognom() {

		ArrayList<Soci> socisList = new ArrayList<Soci>();

		for (Soci scanner : socis.values()) {

			socisList.add(scanner);

		}

		Collections.sort(socisList, new Comparator<Soci>() {
			public int compare(Soci v1, Soci v2) {
				int result = v1.getCognom().compareTo(v2.getCognom());
				if (result == 0) {
					return v1.getNom().compareTo(v2.getNom());
				}
				return result;
			}
		});

		for (Soci scanner : socisList) {

			System.out.println(scanner);
		}
	}

	private void ordenarPerLocalitat() {

		ArrayList<Soci> socisList = new ArrayList<Soci>();

		for (Soci scanner : socis.values()) {

			socisList.add(scanner);

		}

		Collections.sort(socisList, new Comparator<Soci>() {
			public int compare(Soci v1, Soci v2) {
				return v1.getNumLocalitat() - v2.getNumLocalitat();

			}
		});

		for (Soci scanner : socisList) {

			System.out.println(scanner);
		}
	}

	private void ordenarPerQuota() {
		ArrayList<Soci> socisList = new ArrayList<Soci>();

		for (Soci scanner : socis.values()) {
			socisList.add(scanner);
		}

		Collections.sort(socisList, new Comparator<Soci>() {
			public int compare(Soci v1, Soci v2) {
				return v1.getQuotaAnual() - v2.getQuotaAnual();
			}
		});

		for (Soci scanner : socisList) {

			System.out.println(scanner);
		}
	}

}