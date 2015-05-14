package itens;

public class Consumables implements IConsumables {
	private String name;
	private String type;
	private String description;
	
	/*um vetor que contem os valores dos efeitos do consumivel, a posicao [0] representa efeito sombre o CR, [1] sobre o knowledge e [2] sobre o migue*/
	private double effects[];
	
	private int quantity;
	private int duration;
	
	public Consumables (String nome, String descricao, double vida, double ataque, double defesa, int quantidade, int duracao) {				
		setName(nome);		
		setDescription(descricao);
		setEffects(vida, ataque, defesa);
		setQuantity(quantidade);
		setDuration(duracao);
		
		this.type = "Consumível";
		
	}
	
	private void setName(String nome) {
		this.name = nome;
	}
	
	private void setDescription(String descricao) {
		this.description = descricao;
	}
	
	public void setEffects (double cr, double knowledge, double migue) {
		effects[0] = cr;
		effects[1] = knowledge;
		effects[2] = migue;
	}
	
	public void setQuantity(int quantidade) {
		if (quantidade < 1) {
			System.out.println("Erro: quantidade atribuida menor que 1.");
		    
			return;
		}
		
		else 
			this.quantity = quantidade;
	}
	
	public void setDuration (int duracao) {
		if (duracao < 1) {
			System.out.println("Erro: duração atribuida menor que 1.");
		    
			return;
		}
		
		else 
			this.duration = duracao;
	}
	
	/*metodo para pegar o valor que o item recuperda a vida*/
	public double getCR() {
		return this.effects[0];
	}
	
	/*metodo para pegar o valor que o item aumenta o ataque*/
	public double getKnowledge() {
		return this.effects[1];
	}
	
	/*metodo para pegar o valor que o item aumenta a defesa*/
	public double getMigue() {
		return this.effects[2];
	}
	
	/*metodo para pegar a quantidade de usos restantes do item*/
	public int getQuantity() {
		return this.quantity;		
	}
	
	/*metodo para pegar a duracao dos efeitos do item consumivel (se eles modificam o ataque e/ou defesa)*/
	public int getDuration() {
		return this.duration;
	}
	
	/*Metodo para guardar uma quantidade do item que já existe no inventorio do personagem*/	
	public void StockIten (int quantidade) {
		this.quantity += quantidade;
		
	}
	
	/*metodo que imprimira todos os dados do item na seguinte forma:
	 * "Nome"
	 * Tipo: "Tipo"
	 * "Descricao"
	 * CR: +/- recuperacao da vida
	 * Knowledge: +/- aumento do poder de ataque
	 * Migue: +/- aumento do poder de defesa
	 * 
	 * Quantidade de usos
	 * Duracao: "duration" rounds*/
	@Override
	public void Data() {
		// TODO Auto-generated method stub
		System.out.println(name);
		System.out.println("Tipo: " + type);
		System.out.println(description);
		
		
		System.out.println("CR: " + effects[0]);
		System.out.println("Knowledge: " + effects[1]);
		System.out.println("Migue: " + effects[2]);
		
		System.out.println("Usos: " + quantity );			
		System.out.println("Duração: " + duration + (" rounds") );	
		}
}
