package com.edson.tutorialspringmvc.dto;

import java.math.BigDecimal;

import com.edson.tutorialspringmvc.model.Professor;
import com.edson.tutorialspringmvc.model.StatusProfessor;

public class RequisicaoNovoProfessor {
	private String nome;
	private BigDecimal salario;
	private StatusProfessor statusProfessor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public StatusProfessor getStatusProfessor() {
		return statusProfessor;
	}

	public void setStatusProfessor(StatusProfessor statusProfessor) {
		this.statusProfessor = statusProfessor;
	}

	public Professor toProfessor() {
		Professor professor = new Professor();
		professor.setNome(this.nome);
		professor.setSalario(this.salario);
		professor.setStatusProfessor(this.statusProfessor);
		return professor;
	}

	@Override
	public String toString() {
		return "RequisicaoNovoProfessor [nome=" + nome + ", salario=" + salario + ", statusProfessor=" + statusProfessor
				+ "]";
	}

}
