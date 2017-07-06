package br.facape.ponto.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.facape.ponto.model.Curso;
import br.facape.ponto.model.Disciplina;

public class DisciplinaRepository extends AbstractRepository<Disciplina, Long>{

	public DisciplinaRepository() {
		super(Disciplina.class);
	}

	private static final long serialVersionUID = -560678121601387819L;
	
	public List<Disciplina> findByCurso(Curso curso){
		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Disciplina> criteria = criteriaBuilder.createQuery(Disciplina.class);

		final Root<Disciplina> root = criteria.from(Disciplina.class);
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("curso"), curso));

		final TypedQuery<Disciplina> query = entityManager.createQuery(criteria);
		return query.getResultList();
//		return null;
	}

}
