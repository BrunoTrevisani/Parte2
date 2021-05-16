package ParteDois;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaRelatorio {
	ArrayList<CadastroDeAnuncio> lista = new ArrayList<>();
	
	public void cadastraRelatorio() throws ParseException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nome do anúncio: ");
		String nome = scan.next();
		
		System.out.println("Cliente: ");
		String cliente = scan.next();
		
		System.out.println("Data inicial (dd mm aaaa): ");
		String dataErro = scan.nextLine();//Solução (NÃO CONVENCIONAL), para um bug onde o scan pulava para o próximo
		String data = scan.nextLine();
		
		System.out.println("Data término (dd mm aaaa): ");
		String dataf = scan.nextLine();
		
		System.out.println("Investimento por dia: ");
		int investimento = scan.nextInt();
		
		CadastroDeAnuncio re = new CadastroDeAnuncio(nome, cliente, data, dataf, investimento);// Cria um objeto da classe CadastroDeAnuncio
		System.out.println(re.imprimeDados());
		lista.add(re);// Adiciona objeto ao array
	}
	
	public void filtro() {
		Scanner scan = new Scanner(System.in);
		String cliente="";
		String data="";
		String dataf="";
		
		System.out.println("----------Filtro----------\n1 - Procurar por cliente; \n2 - Procurar por data;");
		System.out.println("Informe o numero: ");
		int i = scan.nextInt();
		
		if(i == 1) {
			System.out.println("Cliente: ");
			cliente = scan.next();
			
		}else {
			System.out.println("Data inicial (dd mm aaaa): ");
			String dataErro = scan.nextLine();
			data = scan.nextLine();
			
			System.out.println("Data término (dd mm aaaa): ");
			 dataf = scan.nextLine();
		}
		
		
		for(CadastroDeAnuncio cda: lista) {
			if(cda.getCliente().equals(cliente) || (cda.getDataInicio().equals(data) && cda.getDataFim().equals(dataf) )) {
				System.out.println("----------Relatorio do cliente----------\n"+cda.imprimeDados());
			}
		}
	}

}


