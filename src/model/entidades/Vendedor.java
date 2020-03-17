package model.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vendedor implements Serializable{

	// Classe que representa um departamento

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private Integer idVendedor;
	private String nomeVendedor;
	private String emailVendedor;
	private Date dataNascimentoVendedor;
	private Double salarioBase;
	
	private Departamento departamento;
	
	// Construtores
	public Vendedor() {
	}

	public Vendedor(Integer idVendedor, String nomeVendedor, String emailVendendor, Date dataNascimentoVendendor,
			Double salarioBase, Departamento departamento) {

		this.idVendedor = idVendedor;
		this.nomeVendedor = nomeVendedor;
		this.emailVendedor = emailVendendor;
		this.dataNascimentoVendedor = dataNascimentoVendendor;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	// Getters e Setters
	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public String getEmailVendendor() {
		return emailVendedor;
	}

	public void setEmailVendendor(String emailVendendor) {
		this.emailVendedor = emailVendendor;
	}

	public Date getDataNascimentoVendedor() {
		return dataNascimentoVendedor;
	}

	public void setDataNascimentoVendedor(Date dataNascimentoVendendor) {
		this.dataNascimentoVendedor = dataNascimentoVendendor;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	// Método hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVendedor == null) ? 0 : idVendedor.hashCode());
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
		Vendedor other = (Vendedor) obj;
		if (idVendedor == null) {
			if (other.idVendedor != null)
				return false;
		} else if (!idVendedor.equals(other.idVendedor))
			return false;
		return true;
	}
	
	// Método toString
	@Override
	public String toString() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder criaString = new StringBuilder();
		
		criaString.append("\nId: " + getIdVendedor());
		criaString.append("\nNome: " + getNomeVendedor());
		criaString.append("\nEmail: " + getEmailVendendor());
		criaString.append("\nData de Nascimento: " + formatoData.format(getDataNascimentoVendedor()));
		criaString.append("\nSalário Inicial: " + getSalarioBase());
		criaString.append("\n" + departamento.toString());
		
		return criaString.toString();
	}
}
