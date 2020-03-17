package model.entidades.EstrategiaSQL.implementacao.vend;

import java.util.List;
import java.util.Scanner;

import model.entidades.Vendedor;
import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import servico.ServicoVendedor;

public class FindAllVendedores implements PersistenciaVendedor {

	/* Classe que cont�m a chamada ao m�todo que busca todos os vendores */
	
	@Override
	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor) {
		
		List<Vendedor> listaVendedores = servicoVendedor.findAll();
		listaVendedores.stream().forEach((System.out::println));
		System.out.println("\nOpera��o realizada! Todos os vendedores encontrados!\n");

	}

}
