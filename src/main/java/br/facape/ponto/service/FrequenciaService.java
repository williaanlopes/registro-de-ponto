package br.facape.ponto.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.facape.ponto.model.Frequencia;
import br.facape.ponto.model.Professor;
import br.facape.ponto.repository.FrequenciaRepository;
import br.facape.ponto.repository.ProfessorRepository;
import br.facape.ponto.util.Transacional;

public class FrequenciaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject private FrequenciaRepository frequenciaRepository;
	@Inject private ProfessorRepository professorRepository;
	
	@Transacional
	public Integer registrar(Frequencia frequencia, Professor professor) {
		Integer r = 0;
		try {

			professor = professorRepository.findByMatricula(professor.getMatricula());
			frequencia.setProfessor(professor);
			
			Frequencia f = frequenciaRepository.findFrequencia(frequencia);
			
			if(f == null){
				if(frequenciaRepository.persist(frequencia) != null) r = 1;				
			} else if(f.getRegistroSaida() == null) {
				f.setRegistroSaida(new Date());
				if(frequenciaRepository.persist(f) != null) r = 2;
			} else {
				r = 3;
			}
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return r;
	}
	
	@Transacional
	public boolean find(Frequencia frequencia, Professor professor) {
		boolean r = false;
		try {
			Frequencia f = frequenciaRepository.findFrequencia(frequencia);
			if(f != null) { 
				frequenciaRepository.persist(f);
				r = true;
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return r;
	}

}
