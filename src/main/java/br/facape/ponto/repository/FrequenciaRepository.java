package br.facape.ponto.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.facape.ponto.model.Frequencia;
import br.facape.ponto.model.Professor;

public class FrequenciaRepository extends AbstractRepository<Frequencia, Long> {
	
	private static final String QRFIND = "FROM frequencia WHERE DATE(registro_entrada) = DATE(NOW()) "
			+ "AND id_curso = :id_curso AND id_disciplina = :id_disciplina AND id_professor = :id_professor";

	public FrequenciaRepository() {
		super(Frequencia.class);
	}

	private static final long serialVersionUID = 7245386374132643221L;

	public void salvar(Frequencia frequencia) {
		entityManager.persist(frequencia);
	}
	
	public Frequencia findFrequencia(Frequencia frequencia) {
		Frequencia f = null;
		
		TypedQuery<Frequencia> query  = entityManager.createQuery(QRFIND, Frequencia.class);
		query.setParameter("id_curso", frequencia.getCurso().getId());
		query.setParameter("id_disciplina", frequencia.getDisciplina().getId());
		query.setParameter("id_professor", frequencia.getProfessor().getId());	
		
		List<Frequencia> results = query.getResultList();
        if (results.isEmpty()) f = null;
        else if (results.size() == 1) f = query.getSingleResult();
		
		return f;
	}

	public Frequencia findByPorfessor(Professor professor) {

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Frequencia> criteria = criteriaBuilder.createQuery(Frequencia.class);

		final Root<Frequencia> root = criteria.from(Frequencia.class);
		criteria.select(root);
		criteria.where(criteriaBuilder.equal(root.get("professor"), professor));

		final TypedQuery<Frequencia> query = entityManager.createQuery(criteria);
		return query.getSingleResult();
	}

	public Frequencia update (Frequencia frequencia) {

//		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		final CriteriaQuery<Frequencia> criteria = criteriaBuilder.createQuery(Frequencia.class);
//
//		final Root<Frequencia> root = criteria.from(Frequencia.class);
//		criteria.select(root);
//		criteria.where(criteriaBuilder.equal(root.get("professor"), frequencia));
//
//		final TypedQuery<Frequencia> query = entityManager.createQuery(criteria);
//		
//		entityManager.refresh(frequencia);
//		
//		return query.getSingleResult();
		return null;
	}

}
