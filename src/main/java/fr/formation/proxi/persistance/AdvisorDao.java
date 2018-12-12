package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Advisor;

public class AdvisorDao extends AbstractDao<Advisor> {

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

}
