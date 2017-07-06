package br.facape.ponto.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.facape.ponto.model.AbstractModel;


public abstract class AbstractRepository<T extends AbstractModel, I extends Serializable>
		implements Repository<T, I>, Serializable {

	
	private static final long serialVersionUID = -88392408224343019L;
	
	@Inject
	protected EntityManager entityManager;

	private Class<T> type;

	public AbstractRepository(Class<T> type) {
		this.type = type;
	}

	public AbstractRepository(Class<T> type, EntityManager entityManager) {
		this.type = type;
		this.entityManager = entityManager;
	}

	@Override
	public Optional<T> get(I id) {
		return Optional.ofNullable(entityManager.find(type, id));
	}

	@Override
	public Set<T> get() {
		return new HashSet<>(findAll());
	}

	@Override
	public List<T> findAll() {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> criteria = criteriaBuilder.createQuery(type);

		final Root<T> root = criteria.from(type);
		criteria.select(root);

		final TypedQuery<T> query = entityManager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public T persist(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void remove(T entity) {
		final T managedEntity = entityManager.find(type, entity.getId());
		if (managedEntity != null) {
			entityManager.remove(managedEntity);
		}
	}

	@Override
	public void remove(I id) {
		final T managedEntity = entityManager.find(type, id);
		if (managedEntity != null) {
			entityManager.remove(managedEntity);
		}
	}

	@Override
	public void remove(Collection<T> entities) {

		entities
			.stream()
			.map(AbstractModel::getId)
			.map(id -> entityManager.find(type, id))
			.filter(Objects::nonNull)
			.forEach(entityManager::remove);

	}
	
	@Override
    public void remove(Predicate<T> predicate) {
        remove(get(predicate));
    }

}
