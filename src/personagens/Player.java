package personagens;

public class Player {
	private int andar;
	private String sala;
	private double conhecimento, migue, media;
	
	private final double BASE_CONHEC = 1;
	private final double BASE_MIGUE = 1;
	private final double BASE_MEDIA = 1;
	
	private final double MAX_CONHEC = 100;
	private final double MAX_MIGUE = 100;
	private final double MAX_MEDIA = 100;
	
	public Player () {
		this.andar = 1;
		this.sala = "P1";
		
		this.conhecimento = BASE_CONHEC;
		this.migue = BASE_MIGUE;
		this.media = BASE_MEDIA;
	}
	
	
	public void setPosicao(int andar, String sala) {
		this.andar = andar;
		this.sala = sala;
	}
	
	
	public String getSala() {
		return this.sala;
	}
	
	
	public int getAndar() {
		return this.andar;
	}
	
	
	public double getConhecimento() {
		return this.conhecimento;
	}
	
	
	public double getMigue() {
		return this.migue;
	}
	
	
	public double getMedia() {
		return this.media;
	}


	public double getConhecimentoMax() {
		return this.MAX_CONHEC;
	}
	
	
	public double getMigueMax() {
		return this.MAX_MIGUE;
	}
	
	
	public double getMediaMax() {
		return this.MAX_MEDIA;
	}
	
	
	public void addItem(int andar, String sala) {
		/* adiciona um item (que sera pego da base de dados a partir do andar
		 * e da sala em que o jogador se encontra) na lista de itens do jogador, 
		 * além de já adicionar ao jogador os stats desse item */
		
		/* OBS: como é um método do player, nao precisaria dar o andar e a sala do item */
	}
	
	
	public void ImprimeItens() {
		/* Imprime todos os itens da lista de itens do jogador */	
	}
	
	
	public void proxPorta() {
		/* "aumenta" um no valor da porta e sobe um andar se a porta atual for o BOSS */
	}
	
	
	public void ladoPorta() {
		/* Entra na porta lateral da sala */
	}
	
	
	public void Luta(int andar, String sala) {
		/* Luta contra um inimigo que se encontra naquele andar, naquela sala */
		
		/* OBS: como é um método do player, nao precisaria dar o andar e a sala da luta */
	}
}
