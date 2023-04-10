package tabeller;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AvdelingDAO {
//	private EntityManager em;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");

	public AvdelingDAO() {
	    emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");
	}

	public Avdeling finnAvdelingMedId(int id) {
		EntityManager em = emf.createEntityManager();
	    return em.find(Avdeling.class, id);
	}
	
	public List<Avdeling> finnAlleAvdelinger() {

		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Avdeling> query = em.createQuery("SELECT a FROM Avdeling a", Avdeling.class);
			return query.getResultList();

		} finally {
			em.close();
		}
	}
}
