package ma.ensa.service;

import ma.ensa.entities.Client;
import ma.ensa.entities.Commande;
import ma.ensa.panier.Panier;

public interface IcommandeService {
	public Commande findById(int idEntity);
	public double getTotalPrix(int idCommande);
	public void saveCommande(Panier panier, Client c);
	

}
