package ParteDois;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		int aux = 0;
		ListaRelatorio lr = new ListaRelatorio();
		Scanner scan = new Scanner(System.in);
		
		while(aux == 0) {
			System.out.println("1 - Cadastro de Anuncio \n2 - Procurar anuncio \n3 - Sair");
			int a = scan.nextInt();
			
			if(a == 1) {
				lr.cadastraRelatorio();
			}
			else if (a == 2) {
				lr.filtro();
			}
			else {
				aux++;
			}
		}
		scan.close();
		
	}

}
