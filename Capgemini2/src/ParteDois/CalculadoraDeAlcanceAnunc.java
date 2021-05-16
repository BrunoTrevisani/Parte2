package ParteDois;


public class CalculadoraDeAlcanceAnunc {
	private float pessoaVisualiza;//Pessoas que visualizam o anuncio original
	private float cliquesAnuncio;
	private float compartilhamAnuncio;
	private float visualizacoesNovas;
	private float visualizacaoTotal=0;
	private float dinheiroInvestido;
	private float cliques;
	private float compartilha;

	public float getCliquesAnuncio() {
		return cliquesAnuncio;
	}
	public float getCompartilhamAnuncio() {
		return compartilhamAnuncio;
	}
	public float getVisualizacaoTotal() {
		return visualizacaoTotal;
	}
	
	public CalculadoraDeAlcanceAnunc(float dinheiroInvestido) {
		this.dinheiroInvestido = dinheiroInvestido;
		visualizacaoTotal();
	}
	
	public void visualizacaoTotal() {
		;
		pessoaVisualiza = 30*dinheiroInvestido;//Visualização por dinheiro investido
		visualizacoesNovas = pessoaVisualiza;
		visualizacaoTotal +=visualizacoesNovas;
	
		for(int i=0; i<3; i++) {
			cliques = (visualizacoesNovas*12)/100;//cliques por visualização				
			compartilha = (cliques*3)/20;//Compartilhamentos por cliques				
			visualizacoesNovas = compartilha*40;//Novas visualizações por compartilhamento
			
			visualizacaoTotal +=visualizacoesNovas;
			cliquesAnuncio +=cliques;//Total de cliques
			compartilhamAnuncio += compartilha;//Total de compartilhamentos
			;
		}		
		
	}

	@Override
	public String toString() {
		return "\nCliques no Anuncio: " + cliquesAnuncio + "\nCompartilhamentos: "
				+ compartilhamAnuncio + "\nVisualisações: " + visualizacaoTotal+"\n";
	}
	

}
