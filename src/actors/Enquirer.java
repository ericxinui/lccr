package actors;

import java.util.Scanner;

import interfaces.IEnquirer;
import interfaces.IResponder;

public class Enquirer implements IEnquirer {
	private IResponder resp;

	public Enquirer(IResponder resp) {
		this.resp = resp;
	}
	
	/* Obtem qualquer input do jogador e responde algo com o método resp.Imprime */
	public void Input () {
		boolean sair = false;
		Scanner scan_txt = new Scanner(System.in);
		String input;
		
		while (!sair) {
			input = scan_txt.nextLine();
			
			sair = resp.Imprime(input);
		}
		
		scan_txt.close();
		
		Sair ();
	}
	
	/* Funcao que pode ser utilizada para salvar o jogo */
	public void Sair () {
	}
}
