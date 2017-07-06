package br.facape.ponto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "professor")
public class Professor extends AbstractModel {
		

	private static final long serialVersionUID = -2272347706786120539L;
	
	@Column(nullable=false, length=40)
	private String nome;
	
	@Column(name = "sobre_nome", nullable = false, length = 40)
	private String sobreNome;
	
	@Column(nullable = false)
	private String matricula;

	
	// get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
}
