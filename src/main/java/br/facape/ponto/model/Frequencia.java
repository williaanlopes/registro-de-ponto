package br.facape.ponto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Table
@Entity(name = "frequencia")
public class Frequencia extends AbstractModel {

	private static final long serialVersionUID = 1915074354213364037L;
	
	@ManyToOne
	@JoinColumn(name="id_disciplina", nullable=false)
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name="id_curso", nullable=false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="id_professor", nullable=false)
	private Professor professor;
	
	@Lob
	@Column(name="conteudo_programado")
	private String conteudoProgramado;
	
	@Column(name = "registro_entrada", nullable=false, insertable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date registroEntrada;
	
	@Column(name = "registro_saida", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registroSaida;

	// get e set
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getConteudoProgramado() {
		return conteudoProgramado;
	}

	public void setConteudoProgramado(String conteudoProgramado) {
		this.conteudoProgramado = conteudoProgramado;
	}

	public Date getRegistroEntrada() {
		return registroEntrada;
	}

	public void setRegistroEntrada(Date registroEntrada) {
		this.registroEntrada = registroEntrada;
	}

	public Date getRegistroSaida() {
		return registroSaida;
	}

	public void setRegistroSaida(Date registroSaida) {
		this.registroSaida = registroSaida;
	}
}
