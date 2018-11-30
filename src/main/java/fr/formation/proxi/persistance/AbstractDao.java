package fr.formation.proxi.persistance;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T> implements Dao<T> {

	protected EntityManager em;

	public AbstractDao() {
		this.em = MySqlConnection.getInstance().getEntityManager();
	}
	
	@Override
	public T create(T entity) {
		this.em.getTransaction().begin();
		this.em.persist(entity);
		this.em.getTransaction().commit();
		return entity;
	}
	
	@Override
	public T update(T entity) {
		this.em.getTransaction().begin();
		this.em.merge(entity);
		this.em.getTransaction().commit();
		return entity;
	}

	@SuppressWarnings("unchecked")
	protected T read(Integer id, T entity) {
		T result = null;
		result = (T) this.em.find(entity.getClass(), id);
		return result;
	}
	
	@Override
	public boolean delete(Integer id) {
		this.em.getTransaction().begin();
		T entity = this.read(id);
		this.em.remove(entity);
		this.em.getTransaction().commit();
		return true;
	}
}
