package tabeller;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "obl3")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String avdelingsnavn;

	@OneToOne
	@JoinColumn(name = "sjef_id")
	private Ansatt sjef_id;

	@OneToMany(mappedBy = "avdeling")
	private List<Ansatt> ansatte = new ArrayList<>();

	public Avdeling() {

	}

	public Avdeling(String avdelingsnavn, String sjef_id) {
		this.avdelingsnavn = avdelingsnavn;
	}

	public void leggTilAnsatt(Ansatt ansatt) {
		ansatte.add(ansatt);
		ansatt.setAvdeling(this);
	}

	public void fjernAnsatt(Ansatt ansatt) {
		ansatte.remove(ansatt);
		ansatt.setAvdeling(null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getavdelingsnavn() {
		return avdelingsnavn;
	}

	public void setavdelingsnavn(String avdelingsnavn) {
		this.avdelingsnavn = avdelingsnavn;
	}

	public List<Ansatt> getAnsatte() {
		return ansatte;
	}

	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}

	public Ansatt getSjef() {
		return sjef_id;
	}

	public void setSjef(Ansatt sjef_id) {
		this.sjef_id = sjef_id;
	}

	public void skrivUtMedAnsatte() {
		skrivUt();
		ansatte.forEach(Ansatt::skrivUt);
	}

	public void skrivUt() {
		System.out.printf(" Avdeling %d(%s): %d ansatte, sjef = %s%n", id, avdelingsnavn, ansatte.size(), sjef_id);
	}

}
