package ma.ensa.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ma.ensa.entities.LigneCommande;

@Repository
@Scope("prototype")
public class LigneCommandeDao extends AbstractDao<LigneCommande>
   implements IgenericDao<LigneCommande>{
	

}
