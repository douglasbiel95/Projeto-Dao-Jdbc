package model.entidades.EstrategiaSQL.implementacao.vend;

import java.util.List;
import java.util.Scanner;

import model.entidades.Departamento;
import model.entidades.Vendedor;
import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import servico.ServicoVendedor;

public class FindByDepartmentVendedor implements PersistenciaVendedor {

	@Override
	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor) {
		
		System.out.print("Informe o nome do departamento do vendedor: ");
		String nomeDepartamento = entrada.nextLine();
		
		System.out.print("Informe o Id do departamento do vendedor: ");
		int idDepartamento = entrada.nextInt();
		
		List<Vendedor> listaVendedor = servicoVendedor.findByDepartment(new Departamento(idDepartamento, nomeDepartamento));
		listaVendedor.stream().forEach(System.out::println);
		System.out.println("\nOperação realizada! Vendedores encontrados!\n");

	}

}
