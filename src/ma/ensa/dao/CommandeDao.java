package ma.ensa.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import ma.ensa.entities.Commande;
import ma.ensa.entities.LigneCommande;


@Repository
@Scope("prototype")
public class CommandeDao extends AbstractDao<Commande>
          implements ICommandeDao{

	@Override
	public Set<LigneCommande> getLigneCommandes(int idCommande) {
		Session session = getSessionFactory().getCurrentSession();
		String query = "from LigneCommande as lc where lc.pk.commande.idCommande = :idcommande";
		Set<LigneCommande> ligneCommandes =
				new HashSet<LigneCommande>(session.createQuery(query).setParameter("idcommande", idCommande).list());
		return ligneCommandes;
	}

}
