package br.facape.ponto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina extends AbstractModel {

	private static final long serialVersionUID = -5283667011015245358L;
	
	@Column(nullable = false, length=40)
	private String nome;
	
	@Column(nullable = false, length=40)
	private Integer periodo;

	@Column(nullable = false, length=80)
	private String descricao;

	@ManyToOne
	@JoinColumn(name="id_curso", nullable=false)
	private Curso curso;

	// get e set
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
}
