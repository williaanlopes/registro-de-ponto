package br.facape.ponto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="disciplina_horario")
public class DisciplinaHorario extends AbstractModel {

	private static final long serialVersionUID = -2235482068183870279L;
	
	
	@ManyToOne
	@JoinColumn(name="id_disciplina", nullable=false)
	private Disciplina disciplina;
	
	@Column(nullable = false, length=20)
	private String turno;
	
	@Column(nullable = false, length=20)
	private String dia;
	
	@Column(name = "de_horario", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date deHorario;
	
	@Column(name = "ate_horario", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date ateHorario;

	// get e set
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getDeHorario() {
		return deHorario;
	}

	public void setDeHorario(Date deHorario) {
		this.deHorario = deHorario;
	}

	public Date getAteHorario() {
		return ateHorario;
	}

	public void setAteHorario(Date ateHorario) {
		this.ateHorario = ateHorario;
	}	
}
