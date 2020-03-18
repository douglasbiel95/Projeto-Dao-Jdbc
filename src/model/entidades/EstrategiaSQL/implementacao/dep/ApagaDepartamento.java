package model.entidades.EstrategiaSQL.implementacao.dep;

import java.util.Scanner;

import model.entidades.EstrategiaSQL.PersistenciaDepartamento;
import servico.ServicoDepartamento;

public class ApagaDepartamento implements PersistenciaDepartamento {

	@Override
	public void persistencia(Scanner entrada, ServicoDepartamento servicoDepartamento) {
		System.out.print("Informe o Id para apagar: ");
		int idDepartamento = entrada.nextInt();
		servicoDepartamento.deleteById(idDepartamento);
		System.out.println("\nOperação realizada com sucesso!\n");

	}

}
