package model.entidades.EstrategiaSQL.implementacao.dep;

import java.util.Scanner;

import model.entidades.Departamento;
import model.entidades.EstrategiaSQL.PersistenciaDepartamento;
import servico.ServicoDepartamento;

public class InsereDepartamento implements PersistenciaDepartamento {

	/* Classe que cont�m a chamada de m�todo para inserir um departamento no banco */
	
	@Override
	public void persistencia(Scanner entrada, ServicoDepartamento servicoDepartamento) {
		
		System.out.print("Informe o nome do Departamento a ser criado: ");
		String nomeDepartamento = entrada.nextLine();
		
		/* inst�ncia do departamento */
		servicoDepartamento.insert(new Departamento(null, nomeDepartamento));
		
		System.out.println("\nOpera��o realizada! Departamento inserido!\n");
	}

}
