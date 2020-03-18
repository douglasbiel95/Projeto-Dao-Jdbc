package model.entidades.EstrategiaSQL.implementacao.dep;

import java.util.Scanner;

import model.entidades.Departamento;
import model.entidades.EstrategiaSQL.PersistenciaDepartamento;
import servico.ServicoDepartamento;

public class FindByIdDepartamento implements PersistenciaDepartamento{

	@Override
	public void persistencia(Scanner entrada, ServicoDepartamento servicoDepartamento) {
		System.out.print("Informe o Id do Departamento: ");
		int id = entrada.nextInt();
		Departamento departamento = servicoDepartamento.findById(id);
		System.out.println(departamento);
		System.out.println("Operação realizada! Departamento encontrado!\n");
	}

}
