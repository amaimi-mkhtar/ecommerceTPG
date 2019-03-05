package ma.ensa.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import ma.ensa.entities.Avoir;
import ma.ensa.entities.LigneCommande;

@Repository
@Scope("prototype")
public class AvoirDao extends AbstractDao<Avoir> 
implements IavoirDao{
	@Override
	public Set<LigneCommande> getLigneCommandes(int idAvoir) {
		Session session = getSessionFactory().getCurrentSession();
		String query = "from LigneCommande as lc where lc.avoir.idAvoir = :idAvoir";
		Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>(
				session.createQuery(query).setParameter("idAvoir", idAvoir).list());
		return ligneCommandes;
	}
}
