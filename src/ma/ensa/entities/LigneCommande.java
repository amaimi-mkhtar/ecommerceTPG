package ma.ensa.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
public class LigneCommande implements Serializable{
	
	@EmbeddedId
//	@AttributeOverrides({
//    @AttributeOverride(name = "pk.commande", column = @Column(name = "id_commande")),
//	@AttributeOverride(name = "pk.produit", column = @Column(name = "id_produit")) })
	private LigneCommandeId pk;
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name="idAvoir")
	private Avoir avoir;
	
	public LigneCommande() {
		super();
		this.pk= new LigneCommandeId();
	}
	
	public LigneCommande(Produit produit,Commande commande, int quantite) {
		this.pk = new LigneCommandeId(produit, commande);
		this.quantite = quantite;
	}

	public LigneCommandeId getPk() {
		return pk;
	}

	public void setPk(LigneCommandeId pk) {
		this.pk = pk;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	@Transient
	public Produit getProduit(){
		return pk.getProduit();
	}
	
	@Transient
	public Commande getCommande(){
		return pk.getCommande();
	}
	
	public void setProduit(Produit produit){
		pk.setProduit(produit);
	}
	
	public void setCommande(Commande commande) {
		pk.setCommande(commande);
	}

	public Avoir getAvoir() {
		return avoir;
	}

	public void setAvoir(Avoir avoir) {
		this.avoir = avoir;
	}
	
	

}
