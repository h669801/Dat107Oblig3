package tabeller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		AnsattDAO ansattDAO = new AnsattDAO();
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		Scanner scanner = new Scanner(System.in);
		int menyvalg = scanner.nextInt();
		
		boolean fortsett = true;
        while (fortsett) {
            System.out.println("Velg en handling:");
            System.out.println("1 - Finn ansatt med ID");
            System.out.println("2 - Finn ansatt med brukernavn");
            System.out.println("3 - Finn alle ansatte");
            System.out.println("4 - Legg til ny ansatt");
            System.out.println("5 - Oppdater ansatt");
            System.out.println("6 - Finn avdeling med avdeling-ID");
            System.out.println("7 - Avslutt programmet");

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
                    System.out.println("Skriv inn brukernavn:");
                    String brukernavn = scanner.next();
                    Ansatt ansattMedBrukernavn = ansattDAO.finnAnsattMedbrukernavn(brukernavn);
                    if (ansattMedBrukernavn != null) {
                        System.out.println(ansattMedBrukernavn);
                    } else {
                        System.out.println("Fant ingen ansatt med brukernavn " + brukernavn);
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
                    System.out.println("Skriv inn følgende opplysninger om den nye ansatte:");
                    System.out.println("fornavn:");
                    String fornavn = scanner.next();
                    System.out.println("etternavn:");
                    String etternavn = scanner.next();
                    System.out.println("Brukernavn:");
                    String nyttBrukernavn = scanner.next();
                    System.out.println("ansettelsesdato:");
                    String ansettelsesdato = scanner.next();
                    System.out.println("Stilling:");
                    String stilling = scanner.next();
                    System.out.println("Lønn:");
                    int lønn = scanner.nextInt();
                    System.out.println("avdeling:");
                    String avdeling = scanner.next();
                    System.out.println("prosjekt:");
                    String prosjekt = scanner.next();
                    int id3 = 11;
                    Ansatt nyAnsatt = new Ansatt(id3, nyttBrukernavn, fornavn, etternavn, ansettelsesdato, stilling, lønn);
                    ansattDAO.leggTilAnsatt(nyAnsatt);
                    id3++;
                    System.out.println("Ny ansatt lagt til i databasen.");
                    break;
                case 5:
                    System.out.println("Skriv inn ID til den ansatte som skal oppdateres:");
                    int oppdaterId = scanner.nextInt();
                    Ansatt oppdaterAnsatt = ansattDAO.finnAnsattMedId(oppdaterId);
                    if (oppdaterAnsatt == null) {
                        System.out.println("Fant ingen ansatt med ID " + oppdaterId);
                    } else {
                        System.out.println("Skriv inn den nye stillingen:");
                        String nyStilling = scanner.next();
                        System.out.println("Skriv inn ny lønn: ");
                        int lonn = scanner.nextInt();
                        if (!nyStilling.equals(oppdaterAnsatt.getStilling())) {
                        	oppdaterAnsatt.setStilling(nyStilling);
                        }
                        if (lonn != oppdaterAnsatt.getMaanedslonn()) {
                        	oppdaterAnsatt.setMaanedslonn(lonn);
                        }
                        ansattDAO.oppdaterAnsatt(oppdaterAnsatt);
                        System.out.println("Ansatt oppdatert.");
                    }
                case 6:
                	System.out.println("Skriv inn avdeling ID:");
                    int avdId = scanner.nextInt();
                    Avdeling avdelingMedId = avdelingDAO.finnAvdelingMedId(avdId);
                    if (avdelingMedId != null) {
                        System.out.println(avdelingMedId);
                    } else {
                        System.out.println("Fant ingen avdeling med ID " + avdId);
                    }
                    break;
                case 7:
                	System.out.println("avslutter...");
                	fortsett = false;
                	System.out.println("programmet er avsluttet.");
                	break;
                default:
                     System.out.println("Ugyldig valg.");
                
                    }
        }
        scanner.close();
		
//		while (menyvalg != 6) {
//            menyvalg = hovedmeny();
//            
//            switch (menyvalg) {
//                case 1:
//                    sokAnsattMedId(ansattDAO);
//                    break;
//                case 2:
//                    sokAnsattMedBrukernavn(ansattDAO);
//                    break;
//                case 3:
//                    listAlleAnsatte(ansattDAO);
//                    break;
//                case 4:
//                    oppdaterAnsatt(ansattDAO);
//                    break;
//                case 5:
//                    leggTilAnsatt(ansattDAO);
//                    break;
//                case 6:
//                    System.out.println("Avslutter programmet...");
//                    break;
//                default:
//                    System.out.println("Ugyldig valg, prøv igjen.");
//                    break;
//            }
//        }
//    }
//    
//    public static int hovedmeny() {
//        System.out.println("\n--- HOVEDMENY ---");
//        System.out.println("1. Søk etter ansatt på ansatt-id");
//        System.out.println("2. Søk etter ansatt på brukernavn");
//        System.out.println("3. Utlisting av alle ansatte");
//        System.out.println("4. Oppdater en ansatt sin stilling og/eller lønn");
//        System.out.println("5. Legg inn en ny ansatt");
//        System.out.println("6. Avslutt");
//        System.out.print("\nVelg et menyvalg: ");
//        
//        return Integer.parseInt(System.console().readLine());
//    }
//    
//    public static void sokAnsattMedId(AnsattDAO ansattDAO) {
//        System.out.print("\nSkriv inn ansatt-id: ");
//        int id = Integer.parseInt(System.console().readLine());
//        
//        Ansatt ansatt = ansattDAO.finnAnsattMedId(id);
//        
//        if (ansatt != null) {
//            System.out.println("\nAnsatt funnet: " + ansatt);
//        } else {
//            System.out.println("\nIngen ansatt funnet med id " + id);
//        }
//    }
//    
//    public static void sokAnsattMedBrukernavn(AnsattDAO ansattDAO) {
//        System.out.print("\nSkriv inn brukernavn (initialer): ");
//        String brukernavn = System.console().readLine();
//        
//        Ansatt ansatt = ansattDAO.finnAnsattMedbrukernavn(brukernavn);
//        
//        if (ansatt != null) {
//            System.out.println("\nAnsatt funnet: " + ansatt);
//        } else {
//            System.out.println("\nIngen ansatt funnet med brukernavn " + brukernavn);
//        }
//    }
//    
//    public static void listAlleAnsatte(AnsattDAO ansattDAO) {
//        List<Ansatt> ansatte = ansattDAO.finnAlleAnsatte();
//        
//        System.out.println("\n--- LISTE OVER ALLE ANSATTE ---");
//        
//        for (Ansatt ansatt : ansatte) {
//            System.out.println(ansatt);
//        }
//    }
//    
//    public void oppdaterAnsatt() {
//        System.out.println("Oppdater ansatt sin stilling og/eller lønn");
//
//        int ansattId = Integer.parseInt(getUserInput("Skriv inn ansatt-id: "));
//        Ansatt ansatt = ansattDAO.finnAnsattMedId(ansattId);
//
//        if (ansatt == null) {
//            System.out.println("Ansatt med id " + ansattId + " finnes ikke i systemet.");
//            return;
//        }
//
//        String stilling = getUserInput("Skriv inn ny stilling (trykk enter for å beholde eksisterende stilling): ");
//        if (!stilling.equals("")) {
//            ansatt.setStilling(stilling);
//        }
//
//        String lonnString = getUserInput("Skriv inn ny lønn (trykk enter for å beholde eksisterende lønn): ");
//        if (!lonnString.equals("")) {
//            double lonn = Double.parseDouble(lonnString);
//            ansatt.setLonn(lonn);
//        }
//
//        ansattDAO.oppdaterAnsatt(ansatt);
//        System.out.println("Ansatt med id " + ansattId + " er oppdatert.");
//    }
//
//    public void leggTilAnsatt() {
//        System.out.println("Legg til ny ansatt");
//
//        String fornavn = getUserInput("Skriv inn fornavn: ");
//        String etternavn = getUserInput("Skriv inn etternavn: ");
//        String stilling = getUserInput("Skriv inn stilling: ");
//        double lonn = Double.parseDouble(getUserInput("Skriv inn lønn: "));
//
//        Ansatt ansatt = new Ansatt(fornavn, etternavn, stilling, lonn);
//        ansattDAO.leggTilAnsatt(ansatt);
//        System.out.println("Ny ansatt lagt til med id " + ansatt.getId());
//    }
		
		
//		while (menyvalg != 6) {
//            menyvalg = meny();
//            
//            switch (menyvalg) {
//                case 1:
//                	int input = scanner.nextInt();
//                    Ansatt an = ansattDAO.finnAnsattMedId(input);
//                    an.skrivUt();
//                    break;
//                case 2:
//                	String stringinput = scanner.nextLine();
//                	Ansatt an2 = ansattDAO.finnAnsattMedbrukernavn(stringinput);
//                	an2.skrivUt();
//                    break;
//                case 3:
//                	List<Ansatt> an3 = ansattDAO.finnAlleAnsatte();
//                	for (Ansatt ansatt : an3) {
//                        System.out.println(ansatt);
////                	an3.skrivUt();
//                    break;
//                case 4:
//                	Ansatt an4 = scanner.
//                    ansattDAO.oppdaterAnsatt(ansattInput);
//                    int id = Integer.parseInt(System.console();
//                    break;
//                case 5:
//                    leggTilNyAnsatt(ansattDAO);
//                    break;
//                case 6:
//                    System.out.println("Avslutter programmet...");
//                    break;
//                default:
//                    System.out.println("Ugyldig valg, prøv igjen.");
//                    break;
//            }
//        }
//		 public static int meny() {
//		        System.out.println("\n--- HOVEDMENY ---");
//		        System.out.println("1. Søk etter ansatt på ansatt-id");
//		        System.out.println("2. Søk etter ansatt på brukernavn");
//		        System.out.println("3. Utlisting av alle ansatte");
//		        System.out.println("4. Oppdater en ansatt sin stilling og/eller lønn");
//		        System.out.println("5. Legg inn en ny ansatt");
//		        System.out.println("6. Avslutt");
//		        System.out.print("\nVelg et menyvalg: ");
//		        
//		        return Integer.parseInt(System.console().readLine());


	}
}


