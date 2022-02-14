import javax.swing.JFrame;

public class CalculadoraApp {

	public static void main(String[] args) {

		CalculadoraTela calculadoraFrame = new CalculadoraTela(); // inicializa calculadoraFrame

		calculadoraFrame.setSize(425, 682); // Define o tamanho da janela x, y --> era 380, 682

		calculadoraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sair ao clicar no X
	
		calculadoraFrame.setLocationRelativeTo(null); // Centraliza a janela
		
		calculadoraFrame.setVisible(true); // Deixa a janela visível

	}

}
