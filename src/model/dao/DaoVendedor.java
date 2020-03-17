package model.dao;

import java.util.List;

import model.entidades.Departamento;
import model.entidades.Vendedor;

public interface DaoVendedor {
	// Interface Dao para a classe Vendedor
	
	void insert(Vendedor vendedor);		// Método que insere um objeto do tipo vendedor no banco
	void update(Vendedor vendedor);		// Método que atualiza um objeto do tipo vendedor ja contido no banco
	void deleteById(Integer id);		// Método que deleta um objeto do banco pelo id
	Vendedor findById(Integer id);		// Método que retorna um vendedor pelo id
	List<Vendedor> findAll();			// Método que retorna todos os vendedores
	List<Vendedor> findByDepartment(Departamento departamento);	// Método que retorna todos vendedores pelo dep
}
