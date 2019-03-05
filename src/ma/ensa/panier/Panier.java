package ma.ensa.panier;

import java.util.HashMap;
import java.util.Map;
import ma.ensa.entities.LigneCommande;
import ma.ensa.entities.Produit;

public class Panier {
	
	public Map<Integer,LigneCommande> items = new HashMap<Integer,LigneCommande>();
	
	public void addItem(Produit produit, int quantite)
	{
		LigneCommande lc = items.get(produit.getIdProduit());
		if(lc==null){
			lc = new LigneCommande();
			lc.setProduit(produit);
			lc.setQuantite(quantite);
			items.put(produit.getIdProduit(), lc);
		}
		
		else
			lc.setQuantite(lc.getQuantite()+quantite);
	}
	
	
	public void remove(int idProduit)
	{
		items.remove(idProduit);
	}
	
	public void retirerQuantite(int idProduit, int quantite){
		
	}

	public Map<Integer, LigneCommande> getItems() {
		return items;
	}

	public void setItems(Map<Integer, LigneCommande> items) {
		this.items = items;
	}
	
}
