package model.entidades.enums;

import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import model.entidades.EstrategiaSQL.implementacao.vend.ApagaVendedor;
import model.entidades.EstrategiaSQL.implementacao.vend.FindAllVendedores;
import model.entidades.EstrategiaSQL.implementacao.vend.FindByDepartmentVendedor;
import model.entidades.EstrategiaSQL.implementacao.vend.FindByIdVendedor;
import model.entidades.EstrategiaSQL.implementacao.vend.InsereVendedor;
import model.entidades.EstrategiaSQL.implementacao.vend.UpdateVendedor;

public enum TipoVendedor {

	/* Conjunto enumerado que instância os objetos que executam os métodos */
	
	INSERE_VENDEDOR {
		@Override
		public PersistenciaVendedor getPersistenciaVendedor() {
			return new InsereVendedor();
		}
	},
	
	FIND_BYID_VENDEDOR {
		@Override
		public PersistenciaVendedor getPersistenciaVendedor() {
			return new FindByIdVendedor();
		}
	},
	
	UPDATE_VENDEDOR {
		@Override
		public PersistenciaVendedor getPersistenciaVendedor() {
			return new UpdateVendedor();
		}
	},
	
	DELETE_VENDEDOR {
		@Override
		public PersistenciaVendedor getPersistenciaVendedor() {
			return new ApagaVendedor();
		}
	},
	
	FINDALL_VENDEDORES {
		@Override
		public PersistenciaVendedor getPersistenciaVendedor() {
			return new FindAllVendedores();
		}
	},
	
	FINDALL_DEPARTMENT_VENDEDORES {
		@Override
		public PersistenciaVendedor getPersistenciaVendedor() {
			return new FindByDepartmentVendedor();
		}
	};
	
	public abstract PersistenciaVendedor getPersistenciaVendedor();
}
