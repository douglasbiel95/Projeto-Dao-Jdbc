package model.entidades.enums;

import model.entidades.EstrategiaSQL.PersistenciaDepartamento;
import model.entidades.EstrategiaSQL.implementacao.dep.ApagaDepartamento;
import model.entidades.EstrategiaSQL.implementacao.dep.FindAllDepartamento;
import model.entidades.EstrategiaSQL.implementacao.dep.FindByIdDepartamento;
import model.entidades.EstrategiaSQL.implementacao.dep.InsereDepartamento;
import model.entidades.EstrategiaSQL.implementacao.dep.UpdateDepartamento;

public enum TipoDepartamento {

	/* Conjunto enumerado que instância os objetos que executam os métodos */
	
	CRIA_DEPARTAMENTO {
		@Override
		public PersistenciaDepartamento getPersistenciaDepartamento() {
			return new InsereDepartamento();
		}
	},
	
	UPDATE_DEPARTAMENTO {
		@Override
		public PersistenciaDepartamento getPersistenciaDepartamento() {
			return new UpdateDepartamento();
		}
	},
	
	DELETEBYID_DEPARTAMENTO {
		@Override
		public PersistenciaDepartamento getPersistenciaDepartamento() {
			return new ApagaDepartamento();
		}
	},
	
	FINDBYID_DEPARTAMENTO {
		@Override
		public PersistenciaDepartamento getPersistenciaDepartamento() {
			return new FindByIdDepartamento();
		}
	},
	
	FINDALL_DEPARTAMENTO {
		@Override
		public PersistenciaDepartamento getPersistenciaDepartamento() {
			return new FindAllDepartamento();
		}
	};

	public abstract PersistenciaDepartamento getPersistenciaDepartamento();

	
}
