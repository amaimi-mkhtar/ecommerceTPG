package ma.ensa.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import ma.ensa.entities.Client;

@Repository
@Scope("prototype")
public class ClientDao extends AbstractDao<Client>
  implements IgenericDao<Client>
{

}
