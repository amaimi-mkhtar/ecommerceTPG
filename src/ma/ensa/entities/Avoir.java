package ma.ensa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Avoir implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAvoir;
	private Date dateAvoir;
	private String motif;
	
	@OneToMany(mappedBy="avoir")
	private Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>();

	public Avoir() {
	}

	public Avoir(Date dateAvoir, String motif, Set<LigneCommande> ligneCommandes) {
		this.dateAvoir = dateAvoir;
		this.motif = motif;
		this.ligneCommandes = ligneCommandes;
	}

	public int getIdAvoir() {
		return idAvoir;
	}

	public void setIdAvoir(int idAvoir) {
		this.idAvoir = idAvoir;
	}

	public Date getDateAvoir() {
		return dateAvoir;
	}

	public void setDateAvoir(Date dateAvoir) {
		this.dateAvoir = dateAvoir;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Set<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
}
