package model.entidades.EstrategiaSQL.implementacao.vend;

import java.util.Scanner;

import model.entidades.Vendedor;
import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import servico.ServicoVendedor;

public class FindByIdVendedor implements PersistenciaVendedor {

	/* Classe que contém uma chamada ao método que procura um vendedor pelo Id */
	
	@Override
	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor) {
		
		System.out.print("Informe o Id do Vendedor: ");
		int idVendedor = entrada.nextInt();
		
		Vendedor vendedor = servicoVendedor.findById(idVendedor);
		System.out.println(vendedor);
		System.out.println("\nOperação realizada! Vendedor encontrado!\n");
		
	}

}
