package model.entidades.EstrategiaSQL.implementacao.dep;

import java.util.Scanner;

import model.entidades.Departamento;
import model.entidades.EstrategiaSQL.PersistenciaDepartamento;
import servico.ServicoDepartamento;

public class UpdateDepartamento implements PersistenciaDepartamento {

	@Override
	public void persistencia(Scanner entrada, ServicoDepartamento servicoDepartamento) {
		System.out.print("Insira o Id do Departamento para fazer o update: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		Departamento departamento = servicoDepartamento.findById(id);
		System.out.print("Informe o novo nome do Departamento: ");
		departamento.setNomeDepartamento(entrada.nextLine());
		servicoDepartamento.update(departamento);
		System.out.println("\nOperação realizada! Update concluído.\n");

	}

}
