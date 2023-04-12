package tabeller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {

		AnsattDAO ansattDAO = new AnsattDAO();
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		Scanner scanner = new Scanner(System.in);

		boolean fortsett = true;
		while (fortsett) {
			System.out.println("Velg en handling:");
			System.out.println("1 - Finn ansatt med ID");
			System.out.println("2 - Finn ansatt med brukernavn");
			System.out.println("3 - Finn alle ansatte");
			System.out.println("4 - Legg til ny ansatt");
			System.out.println("5 - Oppdater ansatt");
			System.out.println("6 - Finn avdeling med avdeling-ID");
			System.out.println("7 - Finn alle ansatte i avdeling med avdeling-ID");
			System.out.println("8 - Avslutt programmet");

			int valg = scanner.nextInt();

			switch (valg) {
			case 1:
				System.out.println("Skriv inn ansatt ID:");
				int id = scanner.nextInt();
				Ansatt ansattMedId = ansattDAO.finnAnsattMedId(id);
				if (ansattMedId != null) {
					System.out.println(ansattMedId);
				} else {
					System.out.println("Fant ingen ansatt med ID " + id);
				}
				break;

			case 2:
				System.out.println("Skriv inn brukernavn paa formen (navn.navn eller navn.n) : ");
				String brukernavn = scanner.next();
				List<Ansatt> ansattMedBrukernavn = ansattDAO.finnAnsattMedbrukernavn(brukernavn);
				if (ansattMedBrukernavn.isEmpty()) {
					System.out.println("Ingen ansatte registrert.");
				} else {
					for (Ansatt ansatt : ansattMedBrukernavn) {
						System.out.println(ansatt);
					}
				}
				break;

			case 3:
				List<Ansatt> alleAnsatte = ansattDAO.finnAlleAnsatte();
				if (alleAnsatte.isEmpty()) {
					System.out.println("Ingen ansatte registrert.");
				} else {
					for (Ansatt ansatt : alleAnsatte) {
						System.out.println(ansatt);
					}
				}
				break;

			case 4:
				System.out.println("Skriv inn folgende opplysninger om den nye ansatte : ");
				System.out.println("fornavn : ");
				String fornavn = scanner.next();

				System.out.println("etternavn : ");
				String etternavn = scanner.next();

				System.out.println("Brukernavn (kan vere paa formen alibaba og ali.baba) : ");
				String nyttBrukernavn = scanner.next();

				System.out.println("ansettelsesdato paa formatet (yyyy-MM-dd) : ");
				String ansettelsesdato1 = scanner.next();
				java.sql.Date ansettelsesdato = java.sql.Date.valueOf(ansettelsesdato1);

				System.out.println("Stilling : ");
				String stilling = scanner.next();

				System.out.println("MaanedsLonn : ");
				String inputString = scanner.next();
				Double lønn = Double.parseDouble(inputString);

				System.out.println("avdelingsnummer : ");
				int id2 = scanner.nextInt();
				Avdeling avdeling = ansattDAO.finnAvdeling(id2);

				ansattDAO.leggTilAnsatt(nyttBrukernavn, fornavn, etternavn, ansettelsesdato, stilling, lønn, avdeling);
				System.out.println("Ny ansatt er lagt til i databasen.");
				break;

			case 5:
				System.out.println("Skriv inn ID til den ansatte som skal oppdateres : ");
				int oppdaterId = scanner.nextInt();
				Ansatt oppdaterAnsatt = ansattDAO.finnAnsattMedId(oppdaterId);

				if (oppdaterAnsatt == null) {
					System.out.println("Fant ingen ansatt med ID " + oppdaterId);
				} else {
					System.out.println("Skriv inn den nye stillingen : ");
					String nyStilling = scanner.next();

					System.out.println("Skriv inn ny lønn : ");
					String inputString1 = scanner.next();
					Double lonn = Double.parseDouble(inputString1);

					if (!nyStilling.equals(oppdaterAnsatt.getStilling())) {
						oppdaterAnsatt.setStilling(nyStilling);
					}
					if (lonn != oppdaterAnsatt.getMaanedslonn()) {
						oppdaterAnsatt.setMaanedslonn(lonn);
					}
					ansattDAO.oppdaterAnsatt(oppdaterAnsatt);
					System.out.println("Ansatt oppdatert.");
				}
				break;

			case 6:
				System.out.println("Skriv inn avdeling ID : ");
				int avdId = scanner.nextInt();
				avdelingDAO.finnAvdelingMedId(avdId).skrivUt();
				;
				break;

			case 7:
				System.out.println("Skriv inn avdeling ID : ");
				int avdId2 = scanner.nextInt();
				avdelingDAO.finnAvdelingMedId(avdId2).skrivUtMedAnsatte();
				;
				break;

//                case 8:
//                	System.out.println("Skriv inn ID til den ansatte som skal oppdateres:");
//                    int oppdaterId2 = scanner.nextInt();
//                    Ansatt oppdaterAnsatt2 = ansattDAO.finnAnsattMedId(oppdaterId2);
//                    int t = Avdeling.oppdaterId2(oppdaterAnsatt2);
//                    Ansatt p = ansattDAO.leggTilAnsatt(oppdaterAnsatt2);
//                    Ansatt p = Avdeling.leggTilAnsatt(oppdaterAnsatt2);
//                    avdelingDAO.finnAvdelingMedId(oppdaterId2.getId());
//                	break;;

			case 8:
				System.out.println("avslutter...");
				fortsett = false;
				System.out.println("programmet er avsluttet.");
				break;
			default:
				System.out.println("Ugyldig valg.");

			}
		}
		scanner.close();

	}
}
