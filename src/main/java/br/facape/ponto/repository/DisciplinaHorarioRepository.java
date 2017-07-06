package br.facape.ponto.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.facape.ponto.model.Disciplina;
import br.facape.ponto.model.DisciplinaHorario;

public class DisciplinaHorarioRepository extends AbstractRepository<Disciplina, Long>{

	public DisciplinaHorarioRepository() {
		super(Disciplina.class);
	}

	private static final long serialVersionUID = -560678121601315919L;
	
	public List<DisciplinaHorario> findByDisciplina(Disciplina disciplina){
		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<DisciplinaHorario> criteria = criteriaBuilder.createQuery(DisciplinaHorario.class);

		final Root<DisciplinaHorario> root = criteria.from(DisciplinaHorario.class);
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("disciplina"), disciplina));

		final TypedQuery<DisciplinaHorario> query = entityManager.createQuery(criteria);
		return query.getResultList();
	}

}
