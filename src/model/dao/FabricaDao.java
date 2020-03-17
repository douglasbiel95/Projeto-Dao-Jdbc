package model.dao;

import db.DB;
import model.dao.implementacoes.DaoVendedorJDBC;


public class FabricaDao {

	// Classe auxiliar responsável por instânciar os Dao's
	
	// Operações static para instanciar os objetos Dao
	
	// Método que instancia e retorna um objeto do tipo DaoGenerica do tipo Vendedor
	public static DaoVendedor criaDaoVendedor() {
		return new DaoVendedorJDBC(DB.fazConexao());
	}
}
