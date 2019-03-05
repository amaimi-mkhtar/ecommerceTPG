package ma.ensa.service;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import ma.ensa.dao.IgenericDao;
import ma.ensa.entities.Client;
import ma.ensa.entities.Commande;
import ma.ensa.entities.LigneCommande;
import ma.ensa.entities.Produit;
import ma.ensa.panier.Panier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class CommandeServiceTest {

	@Autowired
	private IgenericDao<Produit> produitDao;
	
	@Autowired
	private IcommandeService commandeService;
	
	@Autowired 
	private IgenericDao<Client> clientDao;
	
	
	static Produit produit1,produit2;
    static Panier panier;
    static Client client;
    
	@BeforeClass
	public static void setUp() throws Exception {
		produit1 = new Produit("produit1");
		produit1.setPrix(300);
		produit2 = new Produit("produit1");
		produit2.setPrix(300);
		panier = new Panier();
		client = new Client("nom1","0100000");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		produit1=null;
		produit2=null;
		panier=null;
	}

	@Test
	public void testGetTotalPrix() {
		
	}

	@Test
	public void testSaveCommande() {
	    produitDao.create(produit1);
	    produitDao.create(produit2);
		panier.addItem(produit1,3);
		panier.addItem(produit2,5);
		clientDao.create(client);
		commandeService.saveCommande(panier, client);
		assertNotNull(commandeService.findById(1));
		
	}

}
