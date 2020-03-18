package model.entidades.EstrategiaSQL.implementacao.dep;

import java.util.List;
import java.util.Scanner;

import model.entidades.Departamento;
import model.entidades.EstrategiaSQL.PersistenciaDepartamento;
import servico.ServicoDepartamento;

public class FindAllDepartamento implements PersistenciaDepartamento {

	@Override
	public void persistencia(Scanner entrada, ServicoDepartamento servicoDepartamento) {
		List<Departamento> lista = servicoDepartamento.findAll();
		lista.stream().forEach(System.out::println);
		System.out.println("Operação realizada! Todos os Departamentos listados!\n");

	}

}
