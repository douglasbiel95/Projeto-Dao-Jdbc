package model.dao;

import java.util.List;

import model.entidades.Departamento;

public interface DaoDepartamento {

	// Interface Dao para a classe Departamento
	
	void insert(Departamento departamento);		// M�todo que insere um objeto do tipo departamento no banco
	void update(Departamento departamento);		// M�todo que atualiza um objeto do tipo departamento ja contido no banco
	void deleteById(Integer id);				// M�todo que deleta um objeto do banco pelo id
	Departamento findById(Integer id);			// M�todo que retorna um departamento pelo id
	List<Departamento> findAll();				// M�todo que retorna todos os departamentos
	
}
