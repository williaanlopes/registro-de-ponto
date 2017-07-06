package br.facape.ponto.repository;

import br.facape.ponto.model.Curso;


public class CursoRepository extends AbstractRepository<Curso, Long>{

	private static final long serialVersionUID = -6074901805123567788L;
	
	public CursoRepository() {
		super(Curso.class);
	}

}
