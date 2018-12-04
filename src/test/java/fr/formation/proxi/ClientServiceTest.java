package fr.formation.proxi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import fr.formation.proxi.metier.service.ClientService;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

	private static ClientService SERVICE;

	/**
	 * Bouchon : simulation des méthodes de AccountDao.
	 */
	@Mock
	private AccountDao ACCOUNT_DAO;

	/**
	 * Bouchon : simulation des méthodes de ClientDao.
	 */
	@Mock
	private ClientDao CLIENT_DAO;

	/**
	 * Préparation des tests sur ClientService (Une seule fois pour tous les
	 * tests de cette classe).
	 */
	@BeforeClass
	public static void setUp() {
		ClientServiceTest.SERVICE = new ClientService();
	}

	/**
	 * Préparation effectuée avant chaque test de cette classe.
	 */
	@Before
	public void init() {
		// On remplace les "vrai" DAO par les bouchons de Mockito.
		ClientServiceTest.SERVICE.setDaoAccount(ACCOUNT_DAO);
		ClientServiceTest.SERVICE.setDaoClient(CLIENT_DAO);
		// On indique ensuite comment est simulé chaque appel de méthode des
		// bouchons (Mockito appelle cela "Stubbing").
		Mockito.when(this.CLIENT_DAO.read(1))
				.thenReturn(DataConstants.CLIENT_1);
		Mockito.when(this.ACCOUNT_DAO.update(DataConstants.ACCOUNT_1))
				.thenReturn(DataConstants.ACCOUNT_1);
		Mockito.when(this.ACCOUNT_DAO.update(DataConstants.ACCOUNT_2))
				.thenReturn(DataConstants.ACCOUNT_2);
	}

	@Test
	public void testTransfer() {
		// Premier cas : le virement doit être OK.
		boolean transferResult = ClientServiceTest.SERVICE.transfer(200F, 1, 2,
				1);
		Assert.assertTrue("Le virement n'a pas fonctionné correctement.",
				transferResult);
		// Deuxième cas : le virement est KO car le montant est supérieur au
		// solde du compte débiteur.
		transferResult = ClientServiceTest.SERVICE.transfer(20000F, 1, 2, 1);
		Assert.assertFalse("Le virement n'aurait pas du être effectué...",
				transferResult);
	}

}
