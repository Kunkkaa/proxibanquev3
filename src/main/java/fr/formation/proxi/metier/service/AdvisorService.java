package fr.formation.proxi.metier.service;

import java.util.List;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AdvisorDao;

public class AdvisorService {

	private static final AdvisorService INSTANCE = new AdvisorService();

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static AdvisorService getInstance() {
		return AdvisorService.INSTANCE;
	}

	private AdvisorDao daoAdvisor;

	public AdvisorService() {
		this.daoAdvisor = AdvisorDao.getInstance();
	}

	/**
	 * Méthode à implémenter.
	 * 
	 * @param id l'identifiant du conseiller pour lequel chercher les clients.
	 * @return List<Client> la liste des clients du conseiller demandé.
	 */
	public List<Client> getClientsByAdvisorId(Integer id) {
		// this.daoAdvisor...
		return null;
	}

	/**
	 * Méthode passe-plat pour rechercher un conseiller par son nom.
	 * 
	 * @param username le nom d'utilisateur (login) du conseiller.
	 * @return Integer l'identifiant du conseiller trouvée.
	 */
	public Integer getAdvisorIdByName(String username) {
		// this.daoAdvisor...
		return null;
	}
}
