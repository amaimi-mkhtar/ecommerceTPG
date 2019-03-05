package ma.ensa.dao;

import java.util.Set;

import ma.ensa.entities.Commande;
import ma.ensa.entities.LigneCommande;

public interface ICommandeDao extends IgenericDao<Commande>{
	
	public Set<LigneCommande> getLigneCommandes(int idCommande);

}
