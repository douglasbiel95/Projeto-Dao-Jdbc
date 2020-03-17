package model.entidades;

import java.io.Serializable;	// permite que os objetos sejam transformados em sequencia de bytes, podendo trafegar em rede, serem escritos em arquivos

public class Departamento implements Serializable{
	
	// Classe que representa um departamento

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private Integer idDepartamento;
	private String nomeDepartamento;
	
	// Construtores sobrecarregados
	public Departamento() {
		
	}
	
	public Departamento(Integer idDepartamento, String nomeDepartamento) {
		
		this.idDepartamento = idDepartamento;
		this.nomeDepartamento = nomeDepartamento;
	}
	
	// Getters e setters
	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	// Método hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDepartamento == null) ? 0 : idDepartamento.hashCode());
		return result;
	}

	// Método equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (idDepartamento == null) {
			if (other.idDepartamento != null)
				return false;
		} else if (!idDepartamento.equals(other.idDepartamento))
			return false;
		return true;
	}
	
	// Método toString
	@Override
	public String toString() {
		return String.format("Nome do Departamento: %s%n"
				+ "Id do Departamento: %d%n", getNomeDepartamento(), getIdDepartamento());
	}
}
