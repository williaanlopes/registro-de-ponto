package br.facape.ponto.repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.facape.ponto.model.Professor;

public class ProfessorRepository extends AbstractRepository<Professor, Long>{

	public ProfessorRepository() {
		super(Professor.class);
	}

	private static final long serialVersionUID = 8126692666104013486L;
	
	public Professor findByMatricula(String matricula) {
		
		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Professor> criteria = criteriaBuilder.createQuery(Professor.class);

		final Root<Professor> root = criteria.from(Professor.class);
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("matricula"), matricula));

		final TypedQuery<Professor> query = entityManager.createQuery(criteria);
		return query.getSingleResult();
	}

}
