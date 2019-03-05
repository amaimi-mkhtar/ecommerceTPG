package ma.ensa.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensa.dao.CommandeDao;
import ma.ensa.dao.ICommandeDao;
import ma.ensa.dao.IgenericDao;
import ma.ensa.entities.Client;
import ma.ensa.entities.Commande;
import ma.ensa.entities.LigneCommande;
import ma.ensa.panier.Panier;

@Service
public class CommandeService implements IcommandeService{
	
	@Autowired
	private ICommandeDao commandeDao;
	
	@Autowired 
	private IgenericDao<LigneCommande> ligneCommandeDao;
	
    public Commande findById(int idEntity){
    	return  commandeDao.findById(idEntity);
    }
	
	
	@Override
	public double getTotalPrix(int idCommande) {
	    Set<LigneCommande> ligneCommandes = commandeDao.getLigneCommandes(idCommande);
		double total=0;
	    for(LigneCommande lc : ligneCommandes)
	    {
	    	total += lc.getProduit().getPrix()*lc.getQuantite();
	    }
		return total;
	}

	@Override
	public void saveCommande(Panier panier, Client c) {
		Commande commande = new Commande();
		commande.setDateCreation(new Date());
		commande.setClient(c);
		Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>(
				panier.getItems().values());
		commande.setLigneCommandes(ligneCommandes);
		commandeDao.create(commande);
		
		for(LigneCommande lc : ligneCommandes)
		{
			lc.setCommande(commande);
			ligneCommandeDao.create(lc);
			
		}
		
	}

}
