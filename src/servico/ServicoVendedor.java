package servico;

import java.util.List;

import model.dao.DaoVendedor;
import model.dao.FabricaDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class ServicoVendedor {

	private DaoVendedor daoVendedor = FabricaDao.criaDaoVendedor();
	
	/* Método que insere */
	public void insert(Vendedor vendedor) {
		daoVendedor.insert(vendedor);
	}
	
	/* Método que faz update */
	public void update(Vendedor vendedor) {
		daoVendedor.update(vendedor);
	}
	
	/* Método que deleta pelo Id */
	public void deleteById(Integer id) {
		daoVendedor.deleteById(id);
	}
	
	/* Método que busca pelo Id */
	public Vendedor findById(Integer id) {
		return daoVendedor.findById(id);
	}
	
	/* Método que retorna todos os Vendedores */
	public List<Vendedor> findAll() {
		return daoVendedor.findAll();
	}
	
	/* Método que retorna todos os vendedores pelo departamento */
	public List<Vendedor> findByDepartment(Departamento departamento) {
		return daoVendedor.findByDepartment(departamento);
	}
}
