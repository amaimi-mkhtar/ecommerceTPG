 package ma.ensa.dao;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ma.ensa.entities.Commande;
import ma.ensa.entities.LigneCommande;
import ma.ensa.entities.Produit;
import config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class LigneCommandeDaoTest {
	
	@Autowired
	private ICommandeDao commandeDao;
	
	@Autowired
	private IgenericDao<Produit> produitDao;
	
	@Autowired
	private IgenericDao<LigneCommande> ligneCommandeDao;
	
	
	static Produit produit1,produit2;
	static Commande commande1;
	static LigneCommande ligneCommande1,ligneCommande2;

	@BeforeClass
	public static void setUp() throws Exception {
		produit1 = new Produit("produit1");
		produit1.setPrix(300);
		produit2 = new Produit("produit1");
		produit2.setPrix(300);
		commande1 = new Commande();
		commande1.setDateCreation(new Date());
		ligneCommande1 = new LigneCommande(produit1, commande1, 3);
		ligneCommande2 = new LigneCommande(produit2, commande1, 5);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		produit1=null;
		produit2=null;
		commande1=null;
		ligneCommande1=null;
		ligneCommande2=null;
	}

	@Test
	public void testCreate() {
		produitDao.create(produit1);
		produitDao.create(produit2);
		commandeDao.create(commande1);
		ligneCommandeDao.create(ligneCommande1);
		ligneCommandeDao.create(ligneCommande2);
		assertEquals(2, commandeDao.getLigneCommandes(commande1.getIdCommande()).size());	
	}

}
