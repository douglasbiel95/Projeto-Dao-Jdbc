package model.dao;

import java.util.List;

import model.entidades.Departamento;

public interface DaoDepartamento {

	// Interface Dao para a classe Departamento
	
	void insert(Departamento departamento);		// Método que insere um objeto do tipo departamento no banco
	void update(Departamento departamento);		// Método que atualiza um objeto do tipo departamento ja contido no banco
	void deleteById(Integer id);				// Método que deleta um objeto do banco pelo id
	Departamento findById(Integer id);			// Método que retorna um departamento pelo id
	List<Departamento> findAll();				// Método que retorna todos os departamentos
	
}
