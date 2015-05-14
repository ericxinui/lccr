package orchestrator;

import eventos.Evento;
import personagens.Player;
import puzzles.Puzzle;
import actors.Enquirer;
import actors.Responder;
import interfaces.IEnquirer;
import interfaces.IResponder;

public class Orchestrator {
	public static void main(String[] args) {
		Player jogador = new Player();
		Puzzle puzzle = new Puzzle();
		Evento evento = new Evento();
		
		IResponder resp = new Responder(jogador, puzzle, evento);
		IEnquirer enq = new Enquirer(resp);
		
		resp.Inicializa();
		enq.Input();
	}
}