package br.facape.ponto.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.facape.ponto.model.Curso;
import br.facape.ponto.model.Disciplina;
import br.facape.ponto.model.DisciplinaHorario;
import br.facape.ponto.model.Frequencia;
import br.facape.ponto.model.Professor;
import br.facape.ponto.repository.CursoRepository;
import br.facape.ponto.repository.DisciplinaHorarioRepository;
import br.facape.ponto.repository.DisciplinaRepository;
import br.facape.ponto.service.FrequenciaService;

@Named
@ManagedBean
@ViewScoped
public class FrequenciaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// services
	@Inject private FrequenciaService frequenciaService;
	
	// repositories
	@Inject private CursoRepository cursoRepository;
	@Inject private DisciplinaRepository disciplinaRepository;
	@Inject private DisciplinaHorarioRepository disciplinaHorarioRepository;
	
	// models
	private Professor professor;
	private Frequencia frequencia;
	
	// lists
	private List<Curso> cursos;
	private List<Disciplina> disciplinas;
	private List<DisciplinaHorario> horarios;
	
	@PostConstruct
	public void iniciar (){
		
		professor = new Professor();
		cursos = new ArrayList<>();
		disciplinas = new ArrayList<>();
		frequencia = new Frequencia();
		horarios = new ArrayList<>();
		
		listarCursos();
	}
	
	// methods
	public void enviar() {

		switch (frequenciaService.registrar(this.frequencia, this.professor)) {
			case 1:
				Messages.addFlashGlobalInfo("ponto.entrada");
				this.frequencia = new Frequencia();
				break;
			case 2:
				Messages.addFlashGlobalInfo("ponto.saida");
				this.frequencia = new Frequencia();
				break;
			case 3:
				Messages.addFlashGlobalError("ponto.existente");
				break;
			default:
				Messages.addFlashGlobalError("ponto.erro");
				break;
		}
		
	}
	
	private void listarCursos(){
		this.cursos = cursoRepository.findAll();
	}
	
	public void listarDisciplinas(AjaxBehaviorEvent event){
		this.disciplinas = disciplinaRepository.findByCurso(frequencia.getCurso());
	}
	
	public void listarHorario(AjaxBehaviorEvent event){
		this.horarios = disciplinaHorarioRepository.findByDisciplina(frequencia.getDisciplina());
	}

	// Getters and Setters
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public List<DisciplinaHorario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<DisciplinaHorario> horarios) {
		this.horarios = horarios;
	}	
	
}
