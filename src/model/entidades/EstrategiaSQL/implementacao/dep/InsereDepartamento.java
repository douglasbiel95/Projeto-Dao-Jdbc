package model.entidades.EstrategiaSQL.implementacao.dep;

import java.util.Scanner;

import model.entidades.Departamento;
import model.entidades.EstrategiaSQL.PersistenciaDepartamento;
import servico.ServicoDepartamento;

public class InsereDepartamento implements PersistenciaDepartamento {

	/* Classe que contém a chamada de método para inserir um departamento no banco */
	
	@Override
	public void persistencia(Scanner entrada, ServicoDepartamento servicoDepartamento) {
		
		System.out.print("Informe o nome do Departamento a ser criado: ");
		String nomeDepartamento = entrada.nextLine();
		
		/* instância do departamento */
		servicoDepartamento.insert(new Departamento(null, nomeDepartamento));
		
		System.out.println("\nOperação realizada! Departamento inserido!\n");
	}

}
