package tabeller;

import jakarta.persistence.EntityManager;

public class AvdelingDAO {
	private EntityManager em;

	public AvdelingDAO(EntityManager em) {
	    this.em = em;
	}

	public Avdeling finnAvdelingMedId(int id) {
	    return em.find(Avdeling.class, id);
	}
}
