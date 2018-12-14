package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Advisor;

public class AdvisorDao extends AbstractDao<Advisor> {

	private static final AdvisorDao INSTANCE = new AdvisorDao();

	public static AdvisorDao getInstance() {
		return AdvisorDao.INSTANCE;
	}

	@Override
	public Advisor read(Integer id) {
		return this.read(id, new Advisor());
	}

	@Override
	public List<Advisor> readAll() {
		List<Advisor> advisors = new ArrayList<>();
		TypedQuery<Advisor> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_ADVISOR, Advisor.class);
		advisors.addAll(query.getResultList());
		return advisors;
	}

	/**
	 * Méthode à implémenter avec une requête JPQL comportant un paramètre.
	 * 
	 * ATTENTION !! Les paramètres des requêtes JPQL ont un fonctionnement
	 * particulier (pas de String.format et de %s). <br>
	 * <a href=
	 * "https://www.objectdb.com/java/jpa/query/parameter#Named_Parameters_:name_">Lien
	 * vers la documentation des paramètres de requête pour JPQL</a>
	 * 
	 * @param username le nom d'utilisateur (login) du conseiller.
	 * @return Integer l'identifiant du conseiller trouvée.
	 */
	public Integer readIdByName(String username) {
		Integer result = null;
		TypedQuery<Advisor> query = this.em.createNamedQuery(
				JpqlQueries.SELECT_ADVISOR_BY_NAME, Advisor.class);
		query.setParameter("username", username);
		result = query.getSingleResult().getId();
		return result;
	}

}
