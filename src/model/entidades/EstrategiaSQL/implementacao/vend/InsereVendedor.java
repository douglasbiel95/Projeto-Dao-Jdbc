package model.entidades.EstrategiaSQL.implementacao.vend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import db.DbException;
import model.entidades.Departamento;
import model.entidades.Vendedor;
import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import servico.ServicoVendedor;


public class InsereVendedor implements PersistenciaVendedor {

	/* Classe que contém a chamada de método para inserir um vendedor no banco */
	
	@Override
	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor) {
		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = null;
		
		System.out.print("Informe o nome do Vendedor: ");
		String nomeVendedor = entrada.nextLine();
		
		System.out.print("Informe o email do Vendedor: ");
		String emailVendedor = entrada.nextLine();
		
		System.out.print("Informe a data de nascimento do Vendedor: ");
		try {
			dataNascimento = formatoData.parse(entrada.nextLine());
		} catch (ParseException e) {
			throw new DbException(e.getMessage());
		}
		
		System.out.print("Informe o salário base do Vendedor R$: ");
		double salarioBase = entrada.nextDouble();
		
		System.out.print("Informe o Id do Departamento: ");
		int id = entrada.nextInt();
		
		/* Intância o vendedor */
		Vendedor vendedor = new Vendedor(id, nomeVendedor,
				emailVendedor, dataNascimento, salarioBase, new Departamento(id, null));
		
		servicoVendedor.insert(vendedor);
		
		System.out.println("\nOperação realizada! Vendedor inserido!\n");

	}

}
