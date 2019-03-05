import java.util.Date;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import ma.ensa.dao.ICommandeDao;
import ma.ensa.dao.IgenericDao;
import ma.ensa.entities.Client;
import ma.ensa.entities.Commande;
import ma.ensa.entities.LigneCommande;
import ma.ensa.entities.Produit;
import ma.ensa.panier.Panier;
import ma.ensa.service.CommandeService;
import ma.ensa.service.IcommandeService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IgenericDao<Produit> daop = (IgenericDao<Produit>) ctx.getBean("produitDao");
		IgenericDao<LigneCommande> daolc = (IgenericDao<LigneCommande>) ctx.getBean("ligneCommandeDao");
		ICommandeDao daoc = (ICommandeDao) ctx.getBean("commandeDao");
		IgenericDao<Client> daocl = (IgenericDao<Client>) ctx.getBean("clientDao");
		
		IcommandeService commandeService =  (IcommandeService) ctx.getBean("commandeService");
		
		Produit produit1 = new Produit("produit1");
		Produit produit2 = new Produit("produit1");
		produit1.setPrix(300);
		produit2.setPrix(600);
	
		daop.create(produit1);
		daop.create(produit2);		
	    Panier panier = new Panier();
	    
	    panier.addItem(produit1, 3);
	    panier.addItem(produit2, 5);
	    
	    Client cl = new Client("nom1", "01000000");
	    
	    daocl.create(cl);
	    commandeService.saveCommande(panier, cl);
	    
	    System.out.println(commandeService.getTotalPrix(1));
	    Produit pr =  daop.findById(1);
	   System.out.println(pr.getPrix());
	}

}
