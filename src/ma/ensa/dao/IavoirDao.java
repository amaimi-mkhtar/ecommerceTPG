package ma.ensa.dao;

import java.util.Set;
import ma.ensa.entities.Avoir;
import ma.ensa.entities.LigneCommande;

public interface IavoirDao extends IgenericDao<Avoir>{
	
	public Set<LigneCommande> getLigneCommandes(int idAvoir);

}
