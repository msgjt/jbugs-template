package edu.msg.ro.business.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.msg.ro.persistence.user.entity.AbstractEntity;

public abstract class AbstractDao<E extends AbstractEntity> {

	@PersistenceContext(unitName = "jbugs-persistence")
	protected EntityManager em;

	public abstract Class<E> getEntityClass();

	public void persistEntity(E entity) {
		em.persist(entity);
		em.flush();
	}

	public void deleteEntity(E entity) {
		em.remove(entity);

	}

	public void mergeEntity(E entity) {
		em.merge(entity);
	}

	public E findEntity(Long id) {
		return em.find(getEntityClass(), id);
	}

}
