package servico;

import java.util.List;

import model.dao.DaoDepartamento;
import model.dao.FabricaDao;
import model.entidades.Departamento;

public class ServicoDepartamento {
	
	private DaoDepartamento daoDepartamento = FabricaDao.criaDaoDepartamento();
	
	public void insert(Departamento departamento) {
		daoDepartamento.insert(departamento);
	}
	
	public void update(Departamento departamento) {
		daoDepartamento.update(departamento);
	}
	
	public void deleteById(Integer id) {
		daoDepartamento.deleteById(id);
	}	
	public Departamento findById(Integer id) {
		return daoDepartamento.findById(id);
	}
	
	public List<Departamento> findAll() {
		return daoDepartamento.findAll();
	}
}
