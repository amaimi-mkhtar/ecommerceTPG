package ma.ensa.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class LigneCommandeId implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	public LigneCommandeId() {
		super();
	}

	public LigneCommandeId(Produit produit, Commande commande) {
		super();
		this.produit = produit;
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	

}
