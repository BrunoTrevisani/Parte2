package ParteDois;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CadastroDeAnuncio  {
	private String nomeDoAnuncio;
	private String cliente;
	private float investimentoDia;
	private long quantidadeDeDias;
	private String dataInicio;
	private String dataFim;
	
	
	public long getQuantidadeDeDias() {
		return quantidadeDeDias;
	}
	public String getNomeDoAnuncio() {
		return nomeDoAnuncio;
	}
	public String getCliente() {
		return cliente;
	}
	public float getInvestimentoDia() {
		return investimentoDia;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	
	public void setNomeDoAnuncio(String nomeDoAnuncio) {
		this.nomeDoAnuncio = nomeDoAnuncio;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public void setInvestimentoDia(float investimentoDia) {
		this.investimentoDia=investimentoDia;
	}

	public void dataEmDias() throws ParseException {//parse precisa de tratamento de exceção
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");// Cria um formato, em string, para a data.
		LocalDate data1 = LocalDate.parse(dataInicio, dtf);
	    LocalDate data2 = LocalDate.parse(dataFim, dtf);
	    quantidadeDeDias = ChronoUnit.DAYS.between(data1, data2); //Retorna a quantidade de dias entre as duas datas.
	    System.out.println ("Days: " + quantidadeDeDias);
	}

	public float investimentoTotal() {
		
		return (quantidadeDeDias*investimentoDia);
	}

	
	public CadastroDeAnuncio(String nomeDoAnuncio, String cliente, String dataInicio, String dataFim, float investimentoDia) throws ParseException {
		
		this.nomeDoAnuncio = nomeDoAnuncio;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.investimentoDia=investimentoDia;
		dataEmDias();
		investimentoTotal();
		CalculadoraDeAlcanceAnunc calc = new CalculadoraDeAlcanceAnunc(investimentoTotal());// Cria um objeto passando investimentoTotal como parametro
		calc.visualizacaoTotal();
		calc.getCliquesAnuncio();
		calc.getCompartilhamAnuncio();
	}
	public CadastroDeAnuncio() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String imprimeDados() {
		CalculadoraDeAlcanceAnunc calc = new CalculadoraDeAlcanceAnunc(investimentoTotal());
		return "Nome de anúncio: "+nomeDoAnuncio+"\nCliente: "+cliente+"\nData de Inicio: "+dataInicio+
				"\nData de Término: "+dataFim+"\nInvestimento por dia: "+investimentoDia+
				"\n---------Relatório---------\nInvestimento total: "+investimentoTotal()+calc.toString();
	}
	
	
}
