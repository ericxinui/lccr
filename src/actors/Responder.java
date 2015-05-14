package actors;

import java.util.Random;
import java.util.Scanner;

import eventos.Evento;
import personagens.Player;
import puzzles.Puzzle;
import map.Mapa;
import interfaces.IMapa;
import interfaces.IResponder;

public class Responder implements IResponder {
	private IMapa mapa;
	private Player jogador;
	private Puzzle puzzle;
	private Evento evento;
	
	
	public Responder(Player jogador, Puzzle puzzle, Evento evento) { /* evento são os encontros aleatorios (tia da cao=ntina, bixao perdido)*/
		this.mapa = new Mapa();
		this.jogador = jogador;
		this.puzzle = puzzle;
		this.evento = evento;
	}
	
	
	/* Método utilizado quando o jogo se inicia */
	public void Inicializa() {
		/* Descricao inicial do jogo */
		System.out.println("Você acabou de chegar no reino Unicamp, governado pelo temível rei CR...");
		
		/* Imprime o mapa com a posicao atual do jogador */
		mapa.Imprime(1, "P1");
		
		System.out.println("Vamos agora ao primeiro desafio...");
		
		/* Inicializa o puzzle de Pergunta e Resposta */
		puzzle.PergRespInit(1);
		
		jogador.addItem(1, "P1");
	}
	
	
	/* Para qualquer comando de entrada do jogador, o jogo vai responder com uma saida */
	public boolean Imprime (String input) {
		switch (input) {
			
			/* ajuda: Imprime todos os comandos (inputs) que o jogador pode colocar */
			case "ajuda":
				System.out.println("stats: Imprime os stats do seu personagem"
								 + "itens: Imprime os itens do seu personagem"
								 + "prox: Entra na próxima sala"
								 + "lado: Entra na sala ao lado"
								 + "sair: Sai do jogo (todo o progresso será perdido)");
				break;
			
			/* prox: Entra na próxima sala (P1 -> P2 -> P3 -> B -> prox andar) */
			case "prox":
				/* Comando só é válido se o jogador estiver nas salas P1, P2, P3 ou B */
				if ((jogador.getSala() != "T1") && (jogador.getSala() != "T2") && (jogador.getSala() != "T3")) {
					Random num_random = new Random();
					
					jogador.proxPorta();
					
					/* Ao entrar nas salas P2 ou P3 o jogador tem 20% de chance de ter que resolver um Maze */
					if ((num_random.nextInt(5) == 0) && (jogador.getSala() != "P1") && (jogador.getSala() != "B"))
						puzzle.MazeInit(jogador.getAndar());
					
					System.out.printf("%d° andar | %s\n\n", jogador.getAndar(), jogador.getSala());
					
					/* Dependendo da sala em que o jogador se encontra, um puzzle ou luta vai acontecer */
					switch (jogador.getSala()) {
						case "P1":
							puzzle.PergRespInit(jogador.getAndar());
							break;
						case "P2":
							jogador.Luta(jogador.getAndar(), "P2");
							break;
						case "P3":
							puzzle.FaustaoInit(jogador.getAndar());
							break;
						case "B":
							jogador.Luta(jogador.getAndar(), "B");
							break;
					}
					
					/* Adicionando o item-reward no inventório do jogador */
					jogador.addItem(jogador.getAndar(), jogador.getSala());
				}
				/* Caso o jogador esteja na sala T1, T2 ou T3 */
				else
					System.out.println("Comando inválido. Você só pode utilizar o comando"
									 + " 'prox' quando está nas salas P1, P2, P3 ou BOSS. "
									 + "Para voltar à sala anterior use o comando 'lado'."
									 + "Para obter a lista de comandos utilize 'ajuda'.");
				
				break;
			
			/* lado: Entra na sala ao lado */
			case "lado":
				jogador.ladoPorta();
				
				/* Se o jogador entrou em uma sala T1, T2 ou T3 um evento aleatório ocorrerá... */
				if ((jogador.getSala() == "T1") || (jogador.getSala() == "T2") || (jogador.getSala() == "T3")) {
					evento.comecaEvento(jogador.getAndar(), jogador.getSala());
					
					jogador.addItem(jogador.getAndar(), jogador.getSala());
				}
				/* ... se não ele simplesmente volta para a sala anterior */
				else
					System.out.printf("Você voltou para a %s\n", jogador.getSala());
				
				break;
			
			/* stats: Imprime os stats do seu personagem */
			case "stats":
				/* jogador.ImprimeStats(); */
				
				/* ou... */
				
				System.out.printf("########## STATS ##########\n"
								+ "- Conhecimento: %.2f/%.2f\n", jogador.getConhecimento(), jogador.getConhecimentoMax()
								+ "- Migué: %.2f/%.2f\n", jogador.getMigue(), jogador.getMigueMax()
								+ "- Média: %.2f/%.2f\n", jogador.getMedia(), jogador.getMediaMax());
				
				/* imprimira os stats do jogador */
				break;
			
			/* itens: Imprime os itens do seu personagem */
			case "itens":
				jogador.ImprimeItens();
				/* imprimirá os itens do jogador */
				/* Obs.: precisa de um comando para o jogador poder ter mais informações sobre um item */
				break;
			
			/* sair: Sai do jogo */
			case "sair":
				Scanner scan_txt = new Scanner(System.in);
				String txt;
				
				System.out.println("Se você sair do jogo todo o progresso será perdido."
								 + " Tem certeza disso? [(s)im/(n)ão]");
				txt = scan_txt.nextLine();
				
				while ((!txt.equalsIgnoreCase("s")) && (!txt.equalsIgnoreCase("n"))) {
					System.out.println("Comando inválido. Digite 's' para sair do jogo ou 'n' para cancelar a ação.");
					txt = scan_txt.nextLine();
				}
				
				if (txt == "s")
					return true;
				
				break;
			
			/* Qualquer comando diferente dos acima */
			default:
				System.out.println("Comando inválido. Para obter a lista de comandos digite 'ajuda'.");
				break;
		}
		
		return false;
	}
}
