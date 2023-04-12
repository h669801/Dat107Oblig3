package tabeller;

import java.util.List;

//import javax.management.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AnsattDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");
	}

	public Ansatt finnAnsattMedId(int ansatt_id) {

		System.out.println("Kobler til database...");
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Ansatt.class, ansatt_id);
		} finally {
			em.close();
		}
	}

	public Ansatt finnAnsattMedbrukernavn(String brukernavn) {

		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn",
					Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			Ansatt ansatt = (Ansatt) query.getSingleResult();
			return ansatt;
		} finally {
			em.close();
		}
	}

	public List<Ansatt> finnAlleAnsatte() {

		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a", Ansatt.class);
			return query.getResultList();

		} finally {
			em.close();
		}
	}

	public void oppdaterAnsatt(Ansatt ansatt) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(ansatt);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void leggTilAnsatt(String brukernavn, String fornavn, String etternavn, java.sql.Date ansettelsesdato, String stilling, Double maanedslonn, Avdeling avdeling) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Ansatt ansatt = null;
		
		try {
			tx.begin();
			
			ansatt = new Ansatt(brukernavn, fornavn, etternavn,ansettelsesdato,stilling, maanedslonn, avdeling);
			
			em.persist(ansatt);
			
//			Avdeling avdeling1 = new Avdeling();
			avdeling.leggTilAnsatt(ansatt);
			em.merge(avdeling);
			
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	public Avdeling finnAvdeling(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Avdeling.class, id);
        } finally {
            em.close();
        }
    }
}
