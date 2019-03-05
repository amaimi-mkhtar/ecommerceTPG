package ma.ensa.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.ensa.entities.Produit;


@Repository
@Scope("prototype")
public class ProduitDao extends AbstractDao<Produit>
					     implements IgenericDao<Produit> 
{
	
}
