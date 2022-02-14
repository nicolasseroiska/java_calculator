/*
 * Linha 140 (Conferir) Comentario resultado_label
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public final class CalculadoraTela extends JFrame {

	@SuppressWarnings("unused")
	private int posicionaVirgula;

	private int contaVirgula;
	private Calculadora c;
	private String posPonto = "";
	private String verifica = "";
	private String j = "";
	// toolTip
	private ArrayList<String> entradaArray = new ArrayList<>();
	private ArrayList<String> digitosArray = new ArrayList<>();
	private ArrayList<String> historicoArray = new ArrayList<>();
	private ArrayList<String> numerosArray = new ArrayList<>();
	// rotulos
	private JLabel p;

	private JLabel co;

	private JLabel a;

	private JLabel log;

	private JLabel ln;

	private JLabel labelInformacao;

	// campos de texto
	private JTextField entrada;

	private JTextField historico;

	// Criando JTextArea

	// botoes
	private JButton buttonCE;

	private JButton buttonMaisMenos;// novo

	private JButton buttonC;

	private JButton buttonPermutacao;

	private JButton buttonCombinacao;

	private JButton buttonArranjo;

	private JButton buttonFatorial;

	private JButton buttonLogaritmo;// novo

	private JButton buttonLogaritmoNatural;// novo

	private JButton buttonNumeroEuler;// novo

	private JButton buttonNumeroPi;// novo

	private JButton buttonExponencial;// novo

	private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

	private JButton buttonAdicao;

	private JButton buttonSubtracao;

	private JButton buttonX;

	private JButton buttonDivisao;

	private JButton buttonIgualdade;

	private JButton buttonPotencia;

	private JButton buttonPonto;

	private JButton buttonDivideUm;

	// JPanel
	private JPanel gridPanel;

	private JPanel middlePanel;

	private JPanel topPanel;

	// cores
	private Color douradoClaro;

	private Color douradoClaroIgualdade;

	private Color cinzaClaro;

	private Color cinzaEscuro;

	private Color toolTipColor;

	private Color toolTipColorText;
	//

	// no construtor cria os objetos da interface
	// depois vamos mover para um metodo inicializa()
	public CalculadoraTela() {
		super("Calculadora Combinatória");// define o nome-titulo da janela

		c = new Calculadora();

		p = new JLabel("Permutacao");
		p.setFont(new Font("Monospaced", Font.ITALIC, 20));
		p.setBounds(10, 15, 20, 20);
		p.setSize(200, 25);
		p.setForeground(Color.WHITE);
		p.setVisible(false);

		a = new JLabel("Arranjo");
		a.setFont(new Font("Monospaced", Font.ITALIC, 20));
		a.setBounds(10, 15, 20, 20);
		a.setForeground(Color.WHITE);
		a.setSize(200, 25);
		a.setVisible(false);

		co = new JLabel("Combinacao");
		co.setFont(new Font("Monospaced", Font.ITALIC, 20));
		co.setBounds(10, 15, 20, 20);
		co.setSize(200, 25);
		co.setForeground(Color.WHITE);
		co.setVisible(false);

		log = new JLabel("Logaritmo");
		log.setFont(new Font("Monospaced", Font.ITALIC, 20));
		log.setBounds(10, 15, 20, 20);
		log.setSize(200, 25);
		log.setForeground(Color.WHITE);
		log.setVisible(false);

		ln = new JLabel("Logaritmo Natural");
		ln.setFont(new Font("Monospaced", Font.ITALIC, 20));
		ln.setBounds(10, 15, 20, 20);
		ln.setSize(300, 25);
		ln.setForeground(Color.WHITE);
		ln.setVisible(false);

		// criando e configurando cores
		douradoClaro = new Color(171, 140, 89); // 42, 130, 193
		douradoClaroIgualdade = new Color(171, 140, 89);
		cinzaClaro = new Color(31, 31, 31);
		cinzaEscuro = new Color(19, 19, 19);
		toolTipColor = new Color(217, 217, 217);// 54,54,54 //255,255,255 // 255, 250, 250
		toolTipColorText = new Color(171, 140, 89);// 255,255,240 // 171, 140, 89

		// criando e configurando as caixas de texto
		entrada = new JTextField(100);
		entrada.setHorizontalAlignment(SwingConstants.RIGHT);
		entrada.setFont(new Font("Arial", Font.BOLD, 48));
		entrada.setBackground(cinzaClaro);
		entrada.setBorder(null);
		entrada.setForeground(Color.WHITE);
		entrada.setBounds(0, 100, 100, 30);
		entrada.setSize(408, 50);
		entrada.setFocusable(true);
		entrada.setText("0");
		entrada.setFocusable(false);
		digitosArray.add("setou");

		historico = new JTextField(100);
		historico.setHorizontalAlignment(SwingConstants.RIGHT);
		historico.setFont(new Font("Arial", Font.BOLD, 18));
		historico.setBorder(null);
		historico.setBackground(cinzaClaro);
		historico.setForeground(Color.LIGHT_GRAY);
		historico.setBounds(240, 100, 100, 80);
		historico.setEditable(false);
		historico.setBounds(0, 60, 0, 0);
		historico.setSize(405, 30);

		// Criando e configurando botões
		buttonCE = new JButton(); // Botão CE
		buttonCE.setFont(new Font("Arial", Font.BOLD, 18));
		buttonCE.setBorderPainted(false); // Tira as bordas do botão
		try {
			Image imgCE = ImageIO.read(getClass().getResource("resources/backspace_preenchido.png"));
			buttonCE.setIcon(new ImageIcon(imgCE));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		buttonCE.setBackground(cinzaEscuro);
		buttonCE.setForeground(Color.WHITE);
		buttonCE.setPreferredSize(new Dimension(50, 70));
		buttonCE.setFocusable(false);

		buttonC = new JButton("C");
		buttonC.setFont(new Font("Arial", Font.BOLD, 18));
		buttonC.setBorderPainted(false);
		buttonC.setBackground(Color.BLACK);
		buttonC.setForeground(Color.WHITE);
		buttonC.setPreferredSize(new Dimension(50, 70));
		buttonC.setFocusable(false);

		button0 = new JButton("0");
		button0.setFont(new Font("Arial", Font.BOLD, 22));
		button0.setBorderPainted(false);
		button0.setFocusable(false);
		button0.setBackground(Color.BLACK);
		button0.setForeground(Color.WHITE);
		button0.setPreferredSize(new Dimension(50, 70));
		// button0.setToolTipText("Batata");

		button1 = new JButton("1");
		button1.setFont(new Font("Arial", Font.BOLD, 22));
		button1.setBorderPainted(false);
		button1.setFocusable(false);
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.WHITE);
		button1.setPreferredSize(new Dimension(50, 70));

		button2 = new JButton("2");
		button2.setFont(new Font("Arial", Font.BOLD, 22));
		button2.setBorderPainted(false);
		button2.setFocusable(false);
		button2.setBackground(Color.BLACK);
		button2.setForeground(Color.WHITE);
		button2.setPreferredSize(new Dimension(50, 70));

		button3 = new JButton("3");
		button3.setFont(new Font("Arial", Font.BOLD, 22));
		button3.setBorderPainted(false);
		button3.setFocusable(false);
		button3.setBackground(Color.BLACK);
		button3.setForeground(Color.WHITE);
		button3.setPreferredSize(new Dimension(50, 70));

		button4 = new JButton("4");
		button4.setFont(new Font("Arial", Font.BOLD, 22));
		button4.setBorderPainted(false);
		button4.setFocusable(false);
		button4.setBackground(Color.BLACK);
		button4.setForeground(Color.WHITE);
		button4.setPreferredSize(new Dimension(50, 70));

		button5 = new JButton("5");
		button5.setFont(new Font("Arial", Font.BOLD, 22));
		button5.setBorderPainted(false);
		button5.setFocusable(false);
		button5.setBackground(Color.BLACK);
		button5.setForeground(Color.WHITE);
		button5.setPreferredSize(new Dimension(50, 70));

		button6 = new JButton("6");
		button6.setFont(new Font("Arial", Font.BOLD, 22));
		button6.setBorderPainted(false);
		button6.setFocusable(false);
		button6.setBackground(Color.BLACK);
		button6.setForeground(Color.WHITE);
		button6.setPreferredSize(new Dimension(50, 70));

		button7 = new JButton("7");
		button7.setFont(new Font("Arial", Font.BOLD, 22));
		button7.setBorderPainted(false);
		button7.setFocusable(false);
		button7.setBackground(Color.BLACK);
		button7.setForeground(Color.WHITE);
		button7.setPreferredSize(new Dimension(50, 70));

		button8 = new JButton("8");
		button8.setFont(new Font("Arial", Font.BOLD, 22));
		button8.setBorderPainted(false);
		button8.setFocusable(false);
		button8.setBackground(Color.BLACK);
		button8.setForeground(Color.WHITE);
		button8.setPreferredSize(new Dimension(50, 70));

		button9 = new JButton("9");
		button9.setFont(new Font("Arial", Font.BOLD, 22));
		button9.setBorderPainted(false);
		button9.setFocusable(false);
		button9.setBackground(Color.BLACK);
		button9.setForeground(Color.WHITE);
		button9.setPreferredSize(new Dimension(50, 70));

		buttonCombinacao = new JButton("C(n,p)");
		buttonCombinacao.setFont(new Font("Arial", Font.BOLD, 16));
		buttonCombinacao.setBorderPainted(false);
		buttonCombinacao.setBackground(cinzaEscuro);
		buttonCombinacao.setForeground(douradoClaro);
		buttonCombinacao.setPreferredSize(new Dimension(70, 50));
		buttonCombinacao.setFocusable(false);

		buttonPermutacao = new JButton("P(n)"); // era P(n!/a,b,c)
		buttonPermutacao.setFont(new Font("Arial", Font.BOLD, 16));
		buttonPermutacao.setBorderPainted(false);
		buttonPermutacao.setBackground(cinzaEscuro);
		buttonPermutacao.setForeground(douradoClaro);
		buttonPermutacao.setPreferredSize(new Dimension(70, 50));
		buttonPermutacao.setFocusable(false);

		buttonArranjo = new JButton("A(n,p)");
		buttonArranjo.setFont(new Font("Arial", Font.BOLD, 16));
		buttonArranjo.setBorderPainted(false);
		buttonArranjo.setBackground(cinzaEscuro);
		buttonArranjo.setForeground(douradoClaro);
		buttonArranjo.setPreferredSize(new Dimension(70, 50));
		buttonArranjo.setFocusable(false);

		buttonFatorial = new JButton("n!");
		buttonFatorial.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
		buttonFatorial.setBorderPainted(false);
		buttonFatorial.setBackground(cinzaEscuro);
		buttonFatorial.setForeground(douradoClaro);
		buttonFatorial.setFocusable(false);

		// log
		buttonLogaritmo = new JButton("log");
		buttonLogaritmo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
		buttonLogaritmo.setBorderPainted(false);
		buttonLogaritmo.setBackground(cinzaEscuro);
		buttonLogaritmo.setForeground(douradoClaro);
		buttonLogaritmo.setFocusable(false);

		// log
		buttonLogaritmoNatural = new JButton("ln");
		buttonLogaritmoNatural.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
		buttonLogaritmoNatural.setBorderPainted(false);
		buttonLogaritmoNatural.setBackground(cinzaEscuro);
		buttonLogaritmoNatural.setForeground(douradoClaro);
		buttonLogaritmoNatural.setFocusable(false);

		// Euler
		buttonNumeroEuler = new JButton("e");
		buttonNumeroEuler.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
		buttonNumeroEuler.setBorderPainted(false);
		buttonNumeroEuler.setBackground(cinzaEscuro);
		buttonNumeroEuler.setForeground(douradoClaro);
		buttonNumeroEuler.setFocusable(false);

		// Pi
		buttonNumeroPi = new JButton();
		buttonNumeroPi.setFont(new Font("Arial", Font.BOLD, 16));
		buttonNumeroPi.setBorderPainted(false);

		try {
			Image imgPi = ImageIO.read(getClass().getResource("resources/pi.png"));
			buttonNumeroPi.setIcon(new ImageIcon(imgPi));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		buttonNumeroPi.setBackground(cinzaEscuro);
		buttonNumeroPi.setForeground(Color.WHITE);
		buttonNumeroPi.setFocusable(false);

		// Exp
		buttonExponencial = new JButton("exp");
		buttonExponencial.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
		buttonExponencial.setBorderPainted(false);
		buttonExponencial.setBackground(cinzaEscuro);
		buttonExponencial.setForeground(douradoClaro);
		buttonExponencial.setFocusable(false);

		buttonMaisMenos = new JButton();
		buttonMaisMenos.setFont(new Font("Arial", Font.BOLD, 16));
		buttonMaisMenos.setBorderPainted(false);

		try {
			Image imgMM = ImageIO.read(getClass().getResource("resources/mm.png"));
			buttonMaisMenos.setIcon(new ImageIcon(imgMM));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		buttonMaisMenos.setBackground(cinzaEscuro);
		buttonMaisMenos.setForeground(douradoClaro);
		buttonMaisMenos.setPreferredSize(new Dimension(50, 70));
		buttonMaisMenos.setFocusable(false);

		buttonAdicao = new JButton("+");
		buttonAdicao.setFont(new Font("Arial", Font.BOLD, 16));
		buttonAdicao.setBorderPainted(false);
		buttonAdicao.setBackground(cinzaEscuro);
		buttonAdicao.setForeground(Color.WHITE);
		buttonAdicao.setFocusable(false);

		buttonSubtracao = new JButton("-");
		buttonSubtracao.setFont(new Font("Arial", Font.BOLD, 16));
		buttonSubtracao.setBorderPainted(false);
		buttonSubtracao.setBackground(cinzaEscuro);
		buttonSubtracao.setForeground(Color.WHITE);
		buttonSubtracao.setFocusable(false);

		buttonX = new JButton("x");
		buttonX.setFont(new Font("Arial", Font.BOLD, 16));
		buttonX.setBorderPainted(false);
		buttonX.setBackground(cinzaEscuro);
		buttonX.setForeground(Color.WHITE);
		buttonX.setFocusable(false);

		buttonDivisao = new JButton("/");
		buttonDivisao.setFont(new Font("Arial", Font.BOLD, 16));
		buttonDivisao.setBorderPainted(false);
		buttonDivisao.setBackground(cinzaEscuro);
		buttonDivisao.setForeground(Color.WHITE);
		buttonDivisao.setFocusable(false);

		ToolTipManager.sharedInstance().setInitialDelay(0);// setar final setDismissDelay()
		ToolTipManager.sharedInstance().setDismissDelay(100000);
		labelInformacao = new JLabel();
		labelInformacao.setBounds(384, 5, 50, 30);
		labelInformacao.setBackground(cinzaEscuro);
		labelInformacao.setSize(23, 19);
		labelInformacao.setBackground(cinzaClaro);
		String toolTipText = "<html><p>"
				+ "Para utilizar das funcionalidades da nossa calculadora é muito simples!<br><br>"
				+ "Basta clicar em algum número (ou vários), e logo em seguida clicar em <br>"
				+ "outro botão que realize uma operação. E assim, sucessivamente...<br><br>"
				+ "Aqui vai uma lista com exemplos:<br><br>"
				+ "(Não precisa de operação primitiva (x, /, -, +, ^, =) para sua finalização)<br><br>"
				+ "OBS: SEMPRE DIGITAR O NUMERO (OU CONJUNTO) ANTES DE CLICAR EM ALGUMA OPERAÇÃO<br><br>"
				+ "P(n) - Realiza a permutação do número fornecido<br><br>"
				+ "n! - Mostra o valor fatorial do número fornecido<br><br>"
				+ "1/n - Divide 1 pelo número fornecido.<br><br>" + "+/- - Inverte o sinal do número fornecido.<br><br>"
				+ "ln - Realiza o logaritmo natural do número fornecido.<br><br>" + "<hr>"
				+ "(Precisa de operação primitiva para sua finalização)<br><br>"
				+ "Operações realizadas em 2 passos - <br> Ex.: número (ou conjunto) + C(n,p) + número (ou conjunto) + operação primitiva (x, /, -, +, ^, =)<br><br>"
				+ "C(n,p) - Realiza a Combinação dos números fornecidos<br><br>"
				+ "A(n,p) - Realiza o Arranjo dos números fornecidos<br><br>"
				+ "X^Y - Realiza a Potenciação do X pelo Y <br> <br>"
				+ "log - Realiza o Logaritmo de dois números fornecidos <br><br>";

		labelInformacao.setToolTipText(toolTipText);
		UIManager.put("ToolTip.background", toolTipColor);
		UIManager.put("ToolTip.foreground", cinzaClaro);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 14));
		UIManager.put("ToolTip.border", BorderFactory.createLineBorder(new Color(105, 105, 105), 3, false));// 171, 140,
																											// 89
																											// //244,164,96
		try {
			Image imgInformacao = ImageIO.read(getClass().getResource("resources/interrogacao.png"));
			labelInformacao.setIcon(new ImageIcon(imgInformacao));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		buttonPotencia = new JButton();
		buttonPotencia.setFont(new Font("Arial", Font.BOLD, 16));
		buttonPotencia.setBorderPainted(false);
		try {
			Image imgxElevadoy = ImageIO.read(getClass().getResource("resources/xElevadoy.png"));
			buttonPotencia.setIcon(new ImageIcon(imgxElevadoy));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		buttonPotencia.setBackground(cinzaEscuro);
		buttonPotencia.setForeground(Color.WHITE);
		buttonPotencia.setFocusable(false);

		buttonPonto = new JButton(".");
		buttonPonto.setFont(new Font("Arial", Font.BOLD, 26));
		buttonPonto.setBorderPainted(false);
		buttonPonto.setBackground(Color.BLACK);
		buttonPonto.setForeground(Color.WHITE);
		buttonPonto.setFocusable(false);

		buttonDivideUm = new JButton(); // Botão divideUm
		buttonDivideUm.setFont(new Font("Arial", Font.BOLD, 16));
		buttonDivideUm.setBorderPainted(false);
		try {
			Image imgDivideUm = ImageIO.read(getClass().getResource("resources/umbarraene.png"));
			buttonDivideUm.setIcon(new ImageIcon(imgDivideUm));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		buttonDivideUm.setBackground(cinzaEscuro);
		buttonDivideUm.setForeground(Color.WHITE);
		buttonDivideUm.setFocusable(false);

		buttonIgualdade = new JButton("=");
		buttonIgualdade.setFont(new Font("Arial", Font.BOLD, 16));
		buttonIgualdade.setBorderPainted(false);
		buttonIgualdade.setBackground(douradoClaroIgualdade);
		buttonIgualdade.setForeground(Color.WHITE);
		buttonIgualdade.setFocusable(false);

		setResizable(false); // Não permite o usuário mexer no tamanho da calculadora.

		Container mainContainer = this.getContentPane(); // Não está visível
		mainContainer.setLayout(new BorderLayout(0, 0));

		getRootPane().setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GREEN)); // Tirar as bordas

		topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(Color.BLACK, 0));
		topPanel.setBackground(Color.RED);

		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.setLayout(null);

		topPanel.setPreferredSize(new Dimension(200, 213)); // setando o tamanho de topPanel

		middlePanel = new JPanel();
		middlePanel.setBorder(new LineBorder(Color.BLACK, 0));
		middlePanel.setLayout(new FlowLayout(0, 0, 0));

		// Deixar aqui essa parte
		topPanel.add(entrada);
		topPanel.add(labelInformacao);
		topPanel.add(a);
		topPanel.add(co);
		topPanel.add(p);
		topPanel.add(log);
		topPanel.add(ln);
		topPanel.add(historico);

		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(6, 7, 2, 2));// --> 6, 4, 2, 2
		gridPanel.setBorder(new LineBorder(Color.BLACK, 0));

		gridPanel.add(buttonPermutacao);
		gridPanel.add(buttonCombinacao);
		gridPanel.add(buttonArranjo);
		gridPanel.add(buttonMaisMenos);
		gridPanel.add(buttonCE);

		gridPanel.add(buttonFatorial);
		gridPanel.add(buttonNumeroPi);
		gridPanel.add(buttonPotencia);
		gridPanel.add(buttonDivideUm);
		gridPanel.add(buttonAdicao);

		gridPanel.add(buttonNumeroEuler);
		gridPanel.add(button7);
		gridPanel.add(button8);
		gridPanel.add(button9);
		gridPanel.add(buttonSubtracao);

		gridPanel.add(buttonLogaritmo);
		gridPanel.add(button4);
		gridPanel.add(button5);
		gridPanel.add(button6);
		gridPanel.add(buttonX);

		gridPanel.add(buttonLogaritmoNatural);
		gridPanel.add(button1);
		gridPanel.add(button2);
		gridPanel.add(button3);
		gridPanel.add(buttonDivisao);

		gridPanel.add(buttonExponencial);
		gridPanel.add(buttonC);
		gridPanel.add(button0);
		gridPanel.add(buttonPonto);
		gridPanel.add(buttonIgualdade);

		/*
		 * JLabel label = new JLabel("Center Box", SwingConstants.CENTER);
		 * label.setOpaque(true); label.setBorder(new LineBorder(Color.BLACK, 3));
		 */

		// Adicionando JPanel
		mainContainer.add(topPanel, BorderLayout.NORTH);

		// mainContainer.add(middlePanel, BorderLayout.NORTH);
		mainContainer.add(gridPanel, BorderLayout.SOUTH);

		// background Panels
		topPanel.setBackground(cinzaClaro);
		gridPanel.setBackground(cinzaClaro);

		// Manipulador
		ButtonHandler handler = new ButtonHandler(); // instância handler
		// KeyHandler keyHandler = new KeyHandler();

		// Mapeia teclado --> imprime numeros através das teclas.
		// InputMap inputMap;

		/*
		 * inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		 * inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0),"forward");
		 * this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
		 * this.getRootPane().getActionMap().put("forward", new AbstractAction(){
		 * private static final long serialVersionUID = 1L;
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) { trataBotao0(); }
		 * });
		 */

		buttonArranjo.addActionListener(handler);
		buttonPermutacao.addActionListener(handler);
		buttonCombinacao.addActionListener(handler);
		buttonFatorial.addActionListener(handler);

		buttonLogaritmo.addActionListener(handler);
		buttonLogaritmoNatural.addActionListener(handler);
		buttonNumeroEuler.addActionListener(handler);
		buttonNumeroPi.addActionListener(handler);
		buttonExponencial.addActionListener(handler);
		buttonMaisMenos.addActionListener(handler);
		button0.addActionListener(handler);
		// button0.addKeyListener(this);

		button1.addActionListener(handler);
		button2.addActionListener(handler);

		button3.addActionListener(handler);
		// button3.addKeyListener(this);

		button4.addActionListener(handler);
		button5.addActionListener(handler);
		button6.addActionListener(handler);
		button7.addActionListener(handler);
		button8.addActionListener(handler);
		button9.addActionListener(handler);
		buttonC.addActionListener(handler);
		buttonCE.addActionListener(handler);
		buttonAdicao.addActionListener(handler);
		buttonX.addActionListener(handler);
		buttonDivisao.addActionListener(handler);
		buttonSubtracao.addActionListener(handler);
		buttonPotencia.addActionListener(handler);
		buttonPonto.addActionListener(handler);
		buttonDivideUm.addActionListener(handler);
		buttonIgualdade.addActionListener(handler);
	}

	private class ButtonHandler implements ActionListener {
		String recebeCampo, exp;
		boolean temP, temC_A;
		BigDecimal resultado;
		String monitoraIgual = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == buttonPermutacao) {// source PERMUTACAO
				this.algoritmoUmaIns("P");
			} // F-I-M source PERMUTACAO

			if (e.getSource() == buttonFatorial) {// source FATORIAL
				this.algoritmoUmaIns("fat");
			} // F-I-M source FATORIAL

			if (e.getSource() == buttonCombinacao) {// source COMBINACAO
				this.algoritmoDuasIns("C");
			} // F-I-M source COMBINACAO

			if (e.getSource() == buttonArranjo) {// source ARRANJO
				this.algoritmoDuasIns("A");
			} // F-I-M source ARRANJO

			if (e.getSource() == buttonLogaritmo) {// source OPERACAO: "Logaritmo"
				this.algoritmoDuasIns("log");
			} // F-I-M source OPERACAO: "Logaritmo"

			if (e.getSource() == buttonExponencial) {// source OPERACAO: "Exponencial"
				contaVirgula = 0;
				exp = "primeiraVez";

				if (digitosArray.get(digitosArray.size() - 1) == "C" || digitosArray.get(digitosArray.size() - 1) == "A"
						|| digitosArray.get(digitosArray.size() - 1) == "log") {
					return;
				}

				else {
					log.setVisible(false);
					ln.setVisible(false);
					p.setVisible(false);
					a.setVisible(false);
					co.setVisible(false);

					String contatenaNumero = "";

					for (int i = 0; i < numerosArray.size(); i++)// for para contatenar os numeros existentes antes da
																	// operação de adição
						contatenaNumero = contatenaNumero + numerosArray.get(i);

					recebeCampo = entrada.getText();

					int ultimo = historicoArray.size() - 1;

					int ultimo2 = digitosArray.size() - 1;

					if (monitoraIgual == "=")
						entradaArray.clear();

					if (historicoArray.size() == 0) {
						digitosArray.add("exp");

						historicoArray.add("n");
						historicoArray.add("exp");

						entradaArray.add(contatenaNumero);
						this.algoritmoVirgula("", recebeCampo, "");

						ultimo = historicoArray.size() - 1;

						ultimo2 = digitosArray.size() - 1;

					}

					else if (historicoArray.get(ultimo) == "+" || historicoArray.get(ultimo) == "-"
							|| historicoArray.get(ultimo) == "/" || historicoArray.get(ultimo) == "x"
							|| historicoArray.get(ultimo) == "p" || historicoArray.get(ultimo) == "C"
							|| historicoArray.get(ultimo) == "A"
							|| digitosArray.get(ultimo2) == "log" && digitosArray.get(ultimo2) != "exp") {
						historicoArray.add("n");
						historicoArray.add("exp");
						historicoArray.add("n");

						digitosArray.add("exp");

						this.algoritmoVirgula("", recebeCampo, "");
						entradaArray.add(contatenaNumero);
					} else {
						digitosArray.add("exp");

						historicoArray.add("n");
						historicoArray.add("exp");

						entradaArray.add(contatenaNumero);
						this.algoritmoVirgula("", recebeCampo, "");

					}

					monitoraIgual = "";
				}
				numerosArray.clear();
			} // F-I-M source OPERACAO: "Exponencial"

			if (e.getSource() == button0) {// source NUMERO: "0"
				this.algoritmoNums("0");

			} // F-I-M source NUMERO: "0"

			if (e.getSource() == button1) {// source NUMERO: "1"
				this.algoritmoNums("1");

			} // F-I-M source NUMERO: "1"

			if (e.getSource() == button2) {// source NUMERO: "2"
				this.algoritmoNums("2");
			} // F-I-M source NUMERO: "2"

			if (e.getSource() == button3) {// source NUMERO: "3"
				this.algoritmoNums("3");

			} // F-I-M source NUMERO: "3"

			if (e.getSource() == button4) {// source NUMERO: "4"
				this.algoritmoNums("4");

			} // F-I-M source NUMERO: "4"

			if (e.getSource() == button5) {// source NUMERO: "5"
				this.algoritmoNums("5");

			} // F-I-M source NUMERO: "5"

			if (e.getSource() == button6) {// source NUMERO: "6"
				this.algoritmoNums("6");

			} // F-I-M source NUMERO: "6"

			if (e.getSource() == button7) {// source NUMERO: "7"
				this.algoritmoNums("7");

			} // F-I-M source NUMERO: "7"

			if (e.getSource() == button8) {// source NUMERO: "8"
				this.algoritmoNums("8");
			} // F-I-M source NUMERO: "8"

			if (e.getSource() == button9) {// source NUMERO: "9"
				this.algoritmoNums("9");

			} // F-I-M source NUMERO: "9"

			if (e.getSource() == buttonPonto) {// source PONTO
				this.algoritmoNums(".");
			} // F-I-M source PONTO

			if (e.getSource() == buttonDivisao) {// source OPERACAO: "/"
				this.algoritmoOps("/");
			} // F-I-M source OPERACAO: "/"

			if (e.getSource() == buttonDivideUm) {// source OPERACAO: "1/n"
				this.algoritmoUmaIns("1/");
			} // F-I-M source OPERACAO: "1/n"

			if (e.getSource() == buttonPotencia) {// source OPERACAO: "^"
				this.algoritmoOps("^");
			} // F-I-M source POTENCIA

			if (e.getSource() == buttonX) {// source OPERACAO: "X"
				this.algoritmoOps("x");
			} // F-I-M source OPERACAO: "X"

			if (e.getSource() == buttonSubtracao) {// source OPERACAO: "-"
				this.algoritmoOps("-");
			} // F-I-M source OPERACAO: "-"

			if (e.getSource() == buttonAdicao) {// source OPERACAO: "+"
				this.algoritmoOps("+");
			} // F-I-M source OPERACAO: "+"

			if (e.getSource() == buttonLogaritmoNatural) {// source OPERACAO: "LogaritmoNatural"
				this.algoritmoUmaIns("ln");
			} // F-I-M source OPERACAO: "LogaritmoNatural"

			if (e.getSource() == buttonNumeroEuler) {// source OPERACAO: "NumeroEuler"

				this.algoritmoVirgula("2.7182818284590452353602874713527", "", "");
				this.algoritmoTrataFonte("2.7182818284590452353602874713527");

			} // F-I-M source OPERACAO: "NumeroEuler"

			if (e.getSource() == buttonNumeroPi) {// source OPERACAO: "NumeroPi"

				this.algoritmoVirgula("3.1415926535897932384626433832795", "", "");
				this.algoritmoTrataFonte("3.1415926535897932384626433832795");

			} // F-I-M source OPERACAO: "NumeroPi"

			if (e.getSource() == buttonMaisMenos) {// source OPERACAO: "MaisMenos"

				if (entrada.getText().charAt(0) != '-')
					this.algoritmoVirgula("-" + entrada.getText(), "", "");

				else
					this.algoritmoVirgula(entrada.getText().substring(1), "", "");

			} // F-I-M source OPERACAO: "MaisMenos"

			if (e.getSource() == buttonC) {// source OPERACAO: "C"
				log.setVisible(false);
				ln.setVisible(false);
				p.setVisible(false);
				a.setVisible(false);
				co.setVisible(false);

				historicoArray.clear();
				entradaArray.clear();
				digitosArray.clear();
				numerosArray.clear();
				digitosArray.add("buttonC");
				entrada.setText("0");
				historico.setText("");
				numerosArray.clear();
				contaVirgula = 0;
				entrada.setFont(new Font("Arial", Font.BOLD, 48));
				exp = null;
			} // F-I-M source OPERACAO: "C"

			if (e.getSource() == buttonCE) {// source OPERACAO: "CE"

				if (digitosArray.get(digitosArray.size() - 1) == "=" || digitosArray.get(digitosArray.size() - 1) == "C"
						|| digitosArray.get(digitosArray.size() - 1) == "A"
						|| digitosArray.get(digitosArray.size() - 1) == "log"
						|| digitosArray.get(digitosArray.size() - 1) == "+"
						|| digitosArray.get(digitosArray.size() - 1) == "-"
						|| digitosArray.get(digitosArray.size() - 1) == "x"
						|| digitosArray.get(digitosArray.size() - 1) == "/"
						|| digitosArray.get(digitosArray.size() - 1) == "umaIns"
						|| digitosArray.get(digitosArray.size() - 1) == "^") {
					return;
				} else {
					entrada.setText(entrada.getText().substring(0, entrada.getText().length() - 1));

					if (historicoArray.size() > 0) {
						if (entrada.getText().length() == 0)
							historicoArray.remove(historicoArray.size() - 1);
					}

					if (entradaArray.size() > 0) {
						entradaArray.remove(entradaArray.size() - 1);
						entradaArray.add(entrada.getText());

					}
					if (digitosArray.size() > 0)
						digitosArray.remove(digitosArray.size() - 1);

					if (entrada.getText().length() == 0) {
						p.setVisible(false);
						a.setVisible(false);
						co.setVisible(false);
						entrada.setFont(new Font("Arial", Font.BOLD, 48));
						entrada.setText("0");
					}
				}
				digitosArray.add("ce");
			} // F-I-M source OPERACAO: "CE"

			if (e.getSource() == buttonIgualdade) {// source OPERACAO: "="
				contaVirgula = 0;

				while (entradaArray.size() > 2) {
					entradaArray.remove(0);
					entradaArray.remove(0);
				}

				String contatenaNumero = "";

				for (int i = 0; i < numerosArray.size(); i++)// for para contatenar os numeros existentes antes da
																// operação de adição
					contatenaNumero = contatenaNumero + numerosArray.get(i);

				int ultimo2 = digitosArray.size() - 1;

				if (digitosArray.get(ultimo2) == "=" || digitosArray.get(ultimo2) == "setou") {
					monitoraIgual = "=";
					digitosArray.add("=");

					return;
				} else {
					String existe;

					monitoraIgual = "=";

					if (contatenaNumero != "")
						entradaArray.add(contatenaNumero);

					historicoArray.add("n");

					recebeCampo = historico.getText();

					temP = temC_A = false;

					for (int i = 0; i < historicoArray.size(); i++) {
						if (historicoArray.get(i) == "p" || historicoArray.get(i) == "!"
								|| historicoArray.get(i) == "1/" || historicoArray.get(i) == "ln")
							temP = true;

						if (historicoArray.get(i) == "C" || historicoArray.get(i) == "A"
								|| historicoArray.get(i) == "log")
							temC_A = true;
					}

					if (digitosArray.get(ultimo2) == "+" || digitosArray.get(ultimo2) == "-"
							|| digitosArray.get(ultimo2) == "/" || digitosArray.get(ultimo2) == "x"
							|| digitosArray.get(ultimo2) == "^" || digitosArray.get(ultimo2) == "A"
							|| digitosArray.get(ultimo2) == "C" || digitosArray.get(ultimo2) == "log") {

						entradaArray.add(entradaArray.get(entradaArray.size() - 1));

						if (temP == true)
							historico.setText(recebeCampo + "=");
						else if (temC_A == true)
							historico.setText(recebeCampo + entrada.getText() + ")" + "=");
						else
							historico.setText(recebeCampo + entrada.getText() + "=");

						existe = c.verificaEx(entradaArray, historicoArray);

						if (existe == "exDivisaoPorZero") {
							log.setVisible(false);
							ln.setVisible(false);
							p.setVisible(false);
							a.setVisible(false);
							co.setVisible(false);

							historicoArray.clear();
							entradaArray.clear();
							digitosArray.clear();
							entrada.setText("0");
							historico.setText("");
							entrada.setText("Indeterminado");
						}

						else {

							resultado = c.verifica(entradaArray, historicoArray);

							String resultado_ = String.valueOf(resultado);

							BigInteger resultadoI = resultado.toBigInteger();

							BigDecimal bd2 = new BigDecimal(resultadoI);

							if (resultado.subtract(bd2).floatValue() == 0) {
								resultadoI = resultado.toBigInteger();
								resultado_ = String.valueOf(resultadoI);

							}

							this.algoritmoVirgula(resultado_, "", "");

							this.algoritmoTrataFonte(resultado_);

							digitosArray.add("=");
							historicoArray.clear();
							historicoArray.add("n");

							entradaArray.clear();
							entradaArray.add(resultado_);

						}
					}

					else {

						if (temP == true)
							historico.setText(recebeCampo + "=");
						else if (temC_A == true)
							historico.setText(recebeCampo + entrada.getText() + ")" + "=");
						else
							historico.setText(recebeCampo + entrada.getText() + "=");

						existe = c.verificaEx(entradaArray, historicoArray);

						if (existe == "exDivisaoPorZero") {
							log.setVisible(false);
							ln.setVisible(false);
							p.setVisible(false);
							a.setVisible(false);
							co.setVisible(false);

							historicoArray.clear();
							entradaArray.clear();
							digitosArray.clear();
							historico.setText("");
							entrada.setText("Indeterminado");

							digitosArray.add("setou");

						}

						else {

							resultado = c.verifica(entradaArray, historicoArray);

							String resultado_ = String.valueOf(resultado);

							BigInteger resultadoI = resultado.toBigInteger();

							BigDecimal bd2 = new BigDecimal(resultadoI);

							if (resultado.subtract(bd2).floatValue() == 0) {
								resultadoI = resultado.toBigInteger();
								resultado_ = String.valueOf(resultadoI);

							}

							this.algoritmoTrataFonte(resultado_);

							this.algoritmoVirgula(resultado_, "", "");

							digitosArray.add("=");
							historicoArray.clear();
							historicoArray.add("n");

							entradaArray.clear();
							entradaArray.add(resultado_);

						}
					}
				}
				numerosArray.clear();
			} // F-I-M source OPERACAO: "="

		}// F-I-M ActionPerformed

		public void algoritmoVirgula(String resultado, String vExpUm, String vExpDois) {// Inicio metodo
																						// AlgoritmoVirgula

			String j = "";
			String auxExp = ".e+";
			String verificaPassou = "nn";
			int ponto = 0;

			if (resultado != "" || vExpUm != "" || vExpDois != "") {// inicio if --> tem algo no resultado ou exp em
																	// operacao
				numerosArray.clear();

				j = "";
				posPonto = "";
				verifica = "nn";

				if (vExpDois != "" && resultado == "") {
					j = vExpUm + auxExp + vExpDois;
					numerosArray.add(String.valueOf(vExpDois));

				}

				else if (vExpUm != "" && vExpDois == "") {
					j = vExpUm + auxExp + "0";
					numerosArray.add(String.valueOf(vExpUm));

				} else {
					for (int i = 0; i < resultado.length(); i++) {

						if ((j + posPonto).length() == 40) {

						} else {

							if (ponto == i && ponto != 0) {
								verificaPassou = "passou";
							}

							if (resultado.charAt(i) == '.' && verifica == "sim") {
								verifica = "ss";
							} else if (verificaPassou != "passou")
								numerosArray.add(String.valueOf(resultado.charAt(i)));

							if (resultado.charAt(i) == '.') {
								verifica = "sim";
								ponto = i;
							}

							if (verifica == "sim") {
								posPonto = posPonto + resultado.charAt(i);
							}

							else if (numerosArray.size() > 3 && numerosArray.size() % 3 == 1 && verifica != "ss"
									&& verificaPassou != "passou") {

								if (contaVirgula > 0) {

									for (int h = 0; h < numerosArray.size(); h++) {

										if (h == 0)
											j = numerosArray.get(h) + ",";
										else if (h > 3 && h % 3 == 1) {
											j = j + "," + numerosArray.get(h);
										} else {
											j = j + numerosArray.get(h);
										}

										entrada.setText(j);

									}
								} else {
									j = "";

									for (int h = 0; h < numerosArray.size(); h++) {

										if (h == 0) {
											entrada.setText(numerosArray.get(h) + ",");
											j = entrada.getText();
										}

										else {
											j = j + numerosArray.get(h);
										}
										entrada.setText(j);

									}
								}
								posicionaVirgula = 2;
							} else if (numerosArray.size() > 3 && numerosArray.size() % 3 == 2 && verifica != "ss"
									&& verificaPassou != "passou") {

								if (contaVirgula > 0) {
									j = "";

									for (int h = 0; h < numerosArray.size(); h++) {

										if (h == 1)
											j = numerosArray.get(h - 1) + numerosArray.get(h) + ',';

										else if (h > 3 && h % 3 == 1) {
											j = j + numerosArray.get(h) + ",";
										} else {
											j = j + numerosArray.get(h);
										}
										entrada.setText(j);
									}
								} else {
									j = "";

									for (int h = 0; h < numerosArray.size(); h++) {

										if (h == 1) {
											entrada.setText(numerosArray.get(h - 1) + numerosArray.get(h) + ",");
											j = entrada.getText();
										}

										else {
											j = j + numerosArray.get(h);
										}
										entrada.setText(j);
									}

								}
								posicionaVirgula = 0;
							}

							else if (numerosArray.size() > 3 && numerosArray.size() % 3 == 0 && verifica != "ss"
									&& verificaPassou != "passou") {

								if (contaVirgula > 0) {
									j = "";

									for (int h = 0; h < numerosArray.size(); h++) {

										if (h == 2)
											j = numerosArray.get(h - 2) + numerosArray.get(h - 1) + numerosArray.get(h)
													+ ',';

										else if (h > 3 && h % 3 == 2) {
											j = j + numerosArray.get(h) + ",";
										}

										else {
											j = j + numerosArray.get(h);
										}
										entrada.setText(j);
									}

								} else {
									j = "";

									for (int h = 0; h < numerosArray.size(); h++) {

										if (h == 2) {
											entrada.setText(numerosArray.get(h - 2) + numerosArray.get(h - 1)
													+ numerosArray.get(h) + ",");
											j = entrada.getText();
										}

										else {
											j = j + numerosArray.get(h);
										}
										entrada.setText(j);
									}
								}

								posicionaVirgula = 1;
								contaVirgula = contaVirgula + 1;
							}

							else if (verifica != "ss" && verificaPassou != "passou") {
								j = "";
								for (int h = 0; h < numerosArray.size(); h++) {

									j = j + numerosArray.get(h);

								}
							}
						}
					}
					contaVirgula = 0;
				}
			} // fim if --> tem algo no resultado

			else {// inicio else - não tem nada no resultado

				if ((j + posPonto).length() == 40) {

				} else {

					if (resultado == ".") {
						verifica = "sim";
					}
					if (verifica == "sim") {
						posPonto = posPonto + resultado;
					}

					if (numerosArray.size() % 3 == 1) {
						if (contaVirgula > 0) {

							for (int i = 0; i < numerosArray.size(); i++) {

								if (numerosArray.get(i) == ".") {
									j = j + numerosArray.get(i);
								}

								else if (i == 0)
									j = numerosArray.get(i) + ",";

								else if (i > 3 && i % 3 == 1) {
									j = j + "," + numerosArray.get(i);
								} else {
									j = j + numerosArray.get(i);
								}

								entrada.setText(j);

							}
						} else {
							j = "";

							for (int i = 0; i < numerosArray.size(); i++) {
								if (numerosArray.get(i) == ".") {
									j = j + numerosArray.get(i);
								}

								else if (i == 0) {
									entrada.setText(numerosArray.get(i) + ",");
									j = entrada.getText();
								}

								else {
									j = j + numerosArray.get(i);
								}
								entrada.setText(j);

							}

						}
						posicionaVirgula = 2;
					} else if (numerosArray.size() > 3 && numerosArray.size() % 3 == 2) {
						if (contaVirgula > 0) {
							j = "";

							for (int i = 0; i < numerosArray.size(); i++) {

								if (numerosArray.get(i) == ".") {
									j = j + numerosArray.get(i);
								}

								else if (i == 1)
									j = numerosArray.get(i - 1) + numerosArray.get(i) + ',';

								else if (i > 3 && i % 3 == 1) {
									j = j + numerosArray.get(i) + ",";
								} else {
									j = j + numerosArray.get(i);
								}

							}
						} else {

							j = "";

							for (int i = 0; i < numerosArray.size(); i++) {

								if (numerosArray.get(i) == ".") {
									j = j + numerosArray.get(i);
								}

								else if (i == 1) {
									entrada.setText(numerosArray.get(i - 1) + numerosArray.get(i) + ",");
									j = entrada.getText();
								}

								else {
									j = j + numerosArray.get(i);
								}

							}

						}
						posicionaVirgula = 0;
					}

					else if (numerosArray.size() > 3 && numerosArray.size() % 3 == 0) {
						if (contaVirgula > 0) {
							j = "";

							for (int i = 0; i < numerosArray.size(); i++) {

								if (numerosArray.get(i) == ".") {
									j = j + numerosArray.get(i);
								}

								else if (i == 2)
									j = numerosArray.get(i - 2) + numerosArray.get(i - 1) + numerosArray.get(i) + ',';

								else if (i > 3 && i % 3 == 2) {

									j = j + numerosArray.get(i) + ",";
								}

								else {
									j = j + numerosArray.get(i);
								}

							}

						} else {
							j = "";

							for (int i = 0; i < numerosArray.size(); i++) {

								if (numerosArray.get(i) == ".") {
									j = j + numerosArray.get(i);
								}

								else if (i == 2) {
									entrada.setText(numerosArray.get(i - 2) + numerosArray.get(i - 1)
											+ numerosArray.get(i) + ",");
									j = entrada.getText();
								}

								else {
									j = j + numerosArray.get(i);
								}

							}

						}

						posicionaVirgula = 1;
						contaVirgula = contaVirgula + 1;
					}
				}
			} // fim else --> não tem nada no resultado
			if (j == "") {

				for (int i = 0; i < numerosArray.size(); i++) {
					j = j + numerosArray.get(i);
				}

			}

			if (j.length() > 0 && j.charAt(j.length() - 1) == ',') { // tira se o último caracter for uma ","
				j = j.substring(0, j.length() - 1);
			}

			entrada.setText(j + posPonto);

			j = "";

		}// F-I-M metodo AlgoritmoVirgula

		public void algoritmoNums(String num) {// inicio algoritmoNums

			boolean ultimoOp = false;

			int ultimo2 = digitosArray.size() - 1;

			for (int i = 0; i < historicoArray.size(); i++) {

				if (historicoArray.get(i) == "exp")
					exp = "sim";
			}

			for (int i = 0; i < digitosArray.size(); i++) {

				if (digitosArray.get(i) == "exp") {
					ultimoOp = false;
				}

				if (digitosArray.get(i) == "+" || digitosArray.get(i) == "-" || digitosArray.get(i) == "/"
						|| digitosArray.get(i) == "x" || digitosArray.get(i) == "^" || digitosArray.get(i) == "C"
						|| digitosArray.get(i) == "A" || digitosArray.get(i) == "log" || digitosArray.get(i) == "=")

					ultimoOp = true;

			}

			if (digitosArray.get(ultimo2) == "+" || digitosArray.get(ultimo2) == "-" || digitosArray.get(ultimo2) == "/"
					|| digitosArray.get(ultimo2) == "x" || digitosArray.get(ultimo2) == "^"
					|| digitosArray.get(ultimo2) == "umaIns" || digitosArray.get(ultimo2) == "A"
					|| digitosArray.get(ultimo2) == "C" || digitosArray.get(ultimo2) == "log"
					|| digitosArray.get(ultimo2) == "=" || digitosArray.get(ultimo2) == "buttonC"
					|| digitosArray.get(ultimo2) == "ce" || digitosArray.get(ultimo2) == "setou") {

				ultimoOp = true;
			}

			if (entrada.getText().length() == 42) {
				if (digitosArray.get(ultimo2) == "+" || digitosArray.get(ultimo2) == "-"
						|| digitosArray.get(ultimo2) == "/" || digitosArray.get(ultimo2) == "x"
						|| digitosArray.get(ultimo2) == "^" || digitosArray.get(ultimo2) == "umaIns"
						|| digitosArray.get(ultimo2) == "A" || digitosArray.get(ultimo2) == "C"
						|| digitosArray.get(ultimo2) == "log" || digitosArray.get(ultimo2) == "="
						|| digitosArray.get(ultimo2) == "buttonC" || digitosArray.get(ultimo2) == "ce"
						|| digitosArray.get(ultimo2) == "setou") {

					entrada.setText("" + num);
					digitosArray.add(num);
				}

			}

			else if (num == "0" && digitosArray.get(ultimo2) == "setou")
				return;

			else {

				numerosArray.add(num);

				this.algoritmoTrataFonte("");

				if (historicoArray.size() == 0 && digitosArray.size() == 0) {
					recebeCampo = entrada.getText();
					entrada.setText(recebeCampo + num);
					digitosArray.add(num);
				}

				else if (digitosArray.get(ultimo2) == "=" && digitosArray.get(ultimo2) != "aFonte"
						&& historicoArray.get(historicoArray.size() - 1) == "n") {

					numerosArray.clear();
					numerosArray.add(num);

					this.algoritmoVirgula("", "", "");
					digitosArray.add(num);

				} else if (exp == "sim" && ultimoOp != true) {
					this.algoritmoVirgula("", String.valueOf(entrada.getText().charAt(0)), num);
					digitosArray.add(num);
				}

				else if (digitosArray.get(ultimo2) == "+" || digitosArray.get(ultimo2) == "-"
						|| digitosArray.get(ultimo2) == "/" || digitosArray.get(ultimo2) == "x"
						|| digitosArray.get(ultimo2) == "^" || digitosArray.get(ultimo2) == "umaIns"
						|| digitosArray.get(ultimo2) == "A" || digitosArray.get(ultimo2) == "C"
						|| digitosArray.get(ultimo2) == "log" || digitosArray.get(ultimo2) == "="
						|| digitosArray.get(ultimo2) == "buttonC" || digitosArray.get(ultimo2) == "ce"
						|| digitosArray.get(ultimo2) == "setou" && digitosArray.get(ultimo2) != "aFonte") {

					this.algoritmoVirgula("", "", "");
					digitosArray.add(num);
				}

				else if (digitosArray.get(ultimo2) == "+" || digitosArray.get(ultimo2) == "-"
						|| digitosArray.get(ultimo2) == "/" || digitosArray.get(ultimo2) == "x"
						|| digitosArray.get(ultimo2) == "^" || digitosArray.get(ultimo2) == "umaIns"
						|| digitosArray.get(ultimo2) == "A" || digitosArray.get(ultimo2) == "C"
						|| digitosArray.get(ultimo2) == "log" || digitosArray.get(ultimo2) == "="
						|| digitosArray.get(ultimo2) == "buttonC" || digitosArray.get(ultimo2) == "ce"
						|| digitosArray.get(ultimo2) == "setou" && digitosArray.get(ultimo2) != "aFonte") {

					this.algoritmoVirgula("", "", "");
					digitosArray.add(num);
				}

				else if (digitosArray.size() != 0) {
					recebeCampo = entrada.getText();

					for (int i = 0; i < numerosArray.size(); i++) {

						if (numerosArray.get(i) == ".") {
							verifica = "ss";
						}
					}

					if (numerosArray.size() > 3 && verifica != "ss")
						this.algoritmoVirgula("", "", "");

					else {
						entrada.setText(recebeCampo + num);
					}
					digitosArray.add(num);
				} else {
					recebeCampo = entrada.getText();
					entrada.setText(recebeCampo + num);
					digitosArray.add(num);
				}
			}

			this.algoritmoTrataFonte("");

		}// F-I-M algoritmoNums

		public void algoritmoOps(String op) { // inicio algoritmoOps

			contaVirgula = 0;

			String existe;

			if (digitosArray.get(digitosArray.size() - 1) == "C" || digitosArray.get(digitosArray.size() - 1) == "A"
					|| digitosArray.get(digitosArray.size() - 1) == "log") {
				return;
			} else {

				String contatenaNumero = "";

				for (int i = 0; i < numerosArray.size(); i++)// for para contatenar os numeros existentes antes da
																// operação de adição
					contatenaNumero = contatenaNumero + numerosArray.get(i);

				log.setVisible(false);
				ln.setVisible(false);
				p.setVisible(false);
				a.setVisible(false);
				co.setVisible(false);

				recebeCampo = entrada.getText();

				int ultimo = historicoArray.size() - 1;

				int ultimo2 = digitosArray.size() - 1;

				boolean temN = false;

				if (historicoArray.size() > 0 && historicoArray.get(ultimo) == "n") {
					temN = true;
				}

				temP = temC_A = false;

				// if (monitoraIgual == "=") {
				// entradaArray.clear();
				// }

				for (int i = 0; i < historicoArray.size(); i++) {
					if (historicoArray.get(i) == "p" || historicoArray.get(i) == "!" || historicoArray.get(i) == "1/"
							|| historicoArray.get(i) == "ln")
						temP = true;

					if (historicoArray.get(i) == "C" || historicoArray.get(i) == "A" || historicoArray.get(i) == "log")
						temC_A = true;
				}

				// coloca operacao correspondente no lugar de algum operador
				if (digitosArray.get(ultimo2) == "+" || digitosArray.get(ultimo2) == "-"
						|| digitosArray.get(ultimo2) == "/" || digitosArray.get(ultimo2) == "x"
						|| digitosArray.get(ultimo2) == "^" || digitosArray.get(ultimo2) == "A"
						|| digitosArray.get(ultimo2) == "C" || digitosArray.get(ultimo2) == "log"
						|| digitosArray.get(ultimo2) == "umaIns" || digitosArray.get(ultimo2) == "=") {

					if (digitosArray.get(ultimo2) != "umaIns")
						historico.setText(historico.getText().substring(0, historico.getText().length() - 1));

					recebeCampo = historico.getText();
					historico.setText(recebeCampo + " " + op);

					if (temN == true) {
						historicoArray.add(op);
					}

					else if (historicoArray.size() != 0) {
						historicoArray.remove(ultimo);
						historicoArray.add(op);
					}

					if (contatenaNumero != "")
						entradaArray.add(contatenaNumero);

					digitosArray.remove(ultimo2);
					digitosArray.add(op);

				}

				else if (historicoArray.size() == 0) {
					digitosArray.add(op);

					historicoArray.add("n");
					historicoArray.add(op);

					if (contatenaNumero != "")
						entradaArray.add(contatenaNumero);

					historico.setText(recebeCampo + op);

					ultimo = historicoArray.size() - 1;
					ultimo2 = digitosArray.size() - 1;
				}

				else if (digitosArray.get(ultimo) != "+" || digitosArray.get(ultimo) != "-"
						|| digitosArray.get(ultimo) != "/" || digitosArray.get(ultimo) != "x"
						|| digitosArray.get(ultimo) != "A" || digitosArray.get(ultimo) != "C"
						|| digitosArray.get(ultimo2) != "log") {

					historicoArray.add("n");
					recebeCampo = historico.getText();

					if (contatenaNumero != "")
						entradaArray.add(contatenaNumero);

					if (temP == true)
						historico.setText(recebeCampo + " " + op);
					else if (temC_A == true)
						historico.setText(recebeCampo + entrada.getText() + ")" + op);
					else
						historico.setText(recebeCampo + entrada.getText() + op);

					existe = c.verificaEx(entradaArray, historicoArray);

					if (existe == "exDivisaoPorZero") {
						log.setVisible(false);
						ln.setVisible(false);
						p.setVisible(false);
						a.setVisible(false);
						co.setVisible(false);

						historicoArray.clear();
						entradaArray.clear();
						digitosArray.clear();
						historico.setText("");
						entrada.setText("Indeterminado");
						digitosArray.add("setou");
					}

					else {

						resultado = c.verifica(entradaArray, historicoArray);

						String resultado_ = String.valueOf(resultado);

						BigInteger resultadoI = resultado.toBigInteger();

						BigDecimal bd2 = new BigDecimal(resultadoI);

						if (resultado.subtract(bd2).floatValue() == 0) {
							resultadoI = resultado.toBigInteger();
							resultado_ = String.valueOf(resultadoI);
						}

						this.algoritmoVirgula(resultado_, "", "");

						this.algoritmoTrataFonte(resultado_);

						historicoArray.clear();
						historicoArray.add("n");
						historicoArray.add(op);

						digitosArray.add(op);

						entradaArray.clear();
						entradaArray.add(resultado_);
					}
				}

				else if (historicoArray.size() == 2) {
					ultimo = historicoArray.size() - 1;
					ultimo2 = digitosArray.size() - 1;

					recebeCampo = historico.getText();

					if (historicoArray.get(ultimo) == "+" || historicoArray.get(ultimo) == "-"
							|| historicoArray.get(ultimo) == "/" || historicoArray.get(ultimo) == "x"
							|| historicoArray.get(ultimo) == "A" || historicoArray.get(ultimo) == "C"
							|| digitosArray.get(ultimo2) == "log") {
						historicoArray.add("n");

						if (contatenaNumero != "")
							entradaArray.add(contatenaNumero);

						historico.setText(recebeCampo + entradaArray.get(entradaArray.size() - 1) + " " + op);
					} else {
						entrada.setText("");
						historico.setText(recebeCampo + entrada.getText() + " " + op);
					}

					resultado = c.verifica(entradaArray, historicoArray);

					String resultado_ = String.valueOf(resultado);

					BigInteger resultadoI = resultado.toBigInteger();

					BigDecimal bd2 = new BigDecimal(resultadoI);

					if (resultado.subtract(bd2).floatValue() == 0) {
						resultadoI = resultado.toBigInteger();
						resultado_ = String.valueOf(resultadoI);
					}

					this.algoritmoTrataFonte(resultado_);

					this.algoritmoVirgula(resultado_, "", "");

					historicoArray.clear();
					historicoArray.add("n");
					historicoArray.add(op);

					digitosArray.add(op);

					entradaArray.clear();
					entradaArray.add(resultado_);
				}

				else if (historicoArray.get(ultimo) == "+" || historicoArray.get(ultimo) == "-"
						|| historicoArray.get(ultimo) == "/"
						|| historicoArray.get(ultimo) == "x" && digitosArray.get(ultimo2) != op) {
					historicoArray.add("n");

					if (contatenaNumero != "")
						entradaArray.add(contatenaNumero);

				}
				monitoraIgual = "";
			}
			numerosArray.clear();
		}// F-I-M algoritmoOps

		public void algoritmoUmaIns(String op) {

			contaVirgula = 0;

			String existe;

			if (digitosArray.get(digitosArray.size() - 1) == "C" || digitosArray.get(digitosArray.size() - 1) == "A"
					|| digitosArray.get(digitosArray.size() - 1) == "log") {
				return;

			} else {

				String contatenaNumero = "";

				for (int i = 0; i < numerosArray.size(); i++)// for para contatenar os numeros existentes antes da
																// operação de adição
					contatenaNumero = contatenaNumero + numerosArray.get(i);

				if (op == "ln") {
					log.setVisible(false);
					ln.setVisible(true);
					p.setVisible(false);
					a.setVisible(false);
					co.setVisible(false);
				} else if (op == "P") {
					log.setVisible(false);
					ln.setVisible(false);
					p.setVisible(true);
					a.setVisible(false);
					co.setVisible(false);
				} else {
					log.setVisible(false);
					ln.setVisible(false);
					p.setVisible(false);
					a.setVisible(false);
					co.setVisible(false);
				}
				recebeCampo = entrada.getText();

				historicoArray.add("n");

				int ultimo = historicoArray.size() - 1;

				boolean temN = false;

				if (historicoArray.size() > 0 && historicoArray.get(ultimo) == "n") {
					temN = true;
				}

				temP = temC_A = false;

				if (monitoraIgual == "=")
					entradaArray.clear();

				for (int i = 0; i < historicoArray.size(); i++) {
					if (historicoArray.get(i) == "p" || historicoArray.get(i) == "fat" || historicoArray.get(i) == "1/"
							|| historicoArray.get(i) == "ln")
						temP = true;

					if (historicoArray.get(i) == "C" || historicoArray.get(i) == "A" || historicoArray.get(i) == "log")
						temC_A = true;
				}

				historico.setText(op + "(" + contatenaNumero + ")");

				if (temN == true) {
					historicoArray.add(op);
				}

				if (contatenaNumero != "")
					entradaArray.add(contatenaNumero);

				historicoArray.add("n");
				recebeCampo = historico.getText();

				if (contatenaNumero != "")
					entradaArray.add(contatenaNumero);

				if (temP == true)
					historico.setText(recebeCampo + op);
				else if (temC_A == true)
					historico.setText(recebeCampo + entrada.getText() + ")" + op);

				existe = c.verificaEx(entradaArray, historicoArray);

				if (existe == "exDivisaoPorZero") {
					log.setVisible(false);
					ln.setVisible(false);
					p.setVisible(false);
					a.setVisible(false);
					co.setVisible(false);

					historicoArray.clear();
					entradaArray.clear();
					digitosArray.clear();
					historico.setText("");
					entrada.setText("Indeterminado");
					digitosArray.add("setou");
				}

				else {
					resultado = c.verifica(entradaArray, historicoArray);

					String resultado_ = String.valueOf(resultado);

					BigInteger resultadoI = resultado.toBigInteger();

					BigDecimal bd2 = new BigDecimal(resultadoI);

					if (resultado.subtract(bd2).floatValue() == 0) {

						resultadoI = resultado.toBigInteger();
						resultado_ = String.valueOf(resultadoI);
					}

					this.algoritmoVirgula(resultado_, "", "");

					this.algoritmoTrataFonte(resultado_);

					historicoArray.clear();
					historicoArray.add("n");
					historicoArray.add(op);

					digitosArray.add("umaIns");

					entradaArray.clear();
					entradaArray.add(resultado_);
				}

				monitoraIgual = "";
			}
			numerosArray.clear();
		}

		public void algoritmoDuasIns(String op) {
			contaVirgula = 0;

			if (digitosArray.get(digitosArray.size() - 1) == "C" || digitosArray.get(digitosArray.size() - 1) == "A"
					|| digitosArray.get(digitosArray.size() - 1) == "log") {
				return;
			}

			else {

				if (op == "C") {
					log.setVisible(false);
					ln.setVisible(false);
					p.setVisible(false);
					a.setVisible(false);
					co.setVisible(true);
				}

				else if (op == "A") {
					log.setVisible(false);
					ln.setVisible(false);
					p.setVisible(false);
					a.setVisible(true);
					co.setVisible(false);
				} else if (op == "ln") {
					log.setVisible(false);
					ln.setVisible(true);

					p.setVisible(false);

					a.setVisible(false);
					co.setVisible(false);
				}

				else if (op == "log") {
					log.setVisible(true);
					ln.setVisible(false);

					p.setVisible(false);

					a.setVisible(false);
					co.setVisible(false);
				}

				String contatenaNumero = "";

				for (int i = 0; i < numerosArray.size(); i++)// for para contatenar os numeros existentes antes da
																// operação de adição
					contatenaNumero = contatenaNumero + numerosArray.get(i);

				recebeCampo = entrada.getText();

				int ultimo = historicoArray.size() - 1;

				int ultimo2 = digitosArray.size() - 1;

				int ultimo3 = entradaArray.size() - 1;

				String recebeCampoH = historico.getText();

				if (monitoraIgual == "=")
					entradaArray.clear();

				if (historicoArray.size() == 0) {
					digitosArray.add(op);

					historicoArray.add("n");
					historicoArray.add(op);

					entradaArray.add(contatenaNumero);
					historico.setText(op + "(" + recebeCampo + ",");

					ultimo = historicoArray.size() - 1;

					ultimo2 = digitosArray.size() - 1;

				} else if (historicoArray.get(ultimo) == op) {

					if (historicoArray.size() == 2)
						historico.setText(entradaArray.get(ultimo3) + op + "/" + recebeCampo);

					else
						historico.setText(recebeCampoH + "," + entrada.getText());

					historicoArray.add("n");
					entradaArray.add(contatenaNumero);
					historicoArray.add(op);
					digitosArray.add(op);
				}

				else if (digitosArray.get(ultimo2) == "+" || digitosArray.get(ultimo2) == "-"
						|| digitosArray.get(ultimo2) == "/" || digitosArray.get(ultimo2) == "x"
						|| digitosArray.get(ultimo2) == "C") {

					historico.setText(entrada.getText().substring(0, entrada.getText().length() - 1));
					historico.setText(op + "(" + recebeCampo + ",");

					historicoArray.remove(ultimo);
					historicoArray.add(op);

					digitosArray.remove(ultimo2);
					digitosArray.add(op);

				}

				else if (historicoArray.get(ultimo) == "+" || historicoArray.get(ultimo) == "-"
						|| historicoArray.get(ultimo) == "/" || historicoArray.get(ultimo) == "x"
						|| historicoArray.get(ultimo) == "p" || historicoArray.get(ultimo) == "C"
						|| historicoArray.get(ultimo) == "A"
						|| digitosArray.get(ultimo2) == "log" && digitosArray.get(ultimo2) != op) {
					historicoArray.add("n");
					historicoArray.add(op);
					historicoArray.add("n");

					digitosArray.add(op);

					historico.setText(recebeCampoH + op + "(" + recebeCampo + ",");
					entradaArray.add(contatenaNumero);
				} else {
					digitosArray.add(op);

					historicoArray.add("n");
					historicoArray.add(op);

					entradaArray.add(contatenaNumero);
					historico.setText(op + "(" + recebeCampo + ",");

				}

				monitoraIgual = "";
			}
			numerosArray.clear();
		}

		public void algoritmoTrataFonte(String resultado) {// inicio algoritmoNums
			int tamanho;

			if (resultado != "") {

				tamanho = resultado.length();

				if (tamanho >= 37) {
					entrada.setFont(new Font("Arial", Font.BOLD, 18));
				}

				else if (tamanho >= 31) {
					entrada.setFont(new Font("Arial", Font.BOLD, 20));
				}

				else if (tamanho >= 24) {
					entrada.setFont(new Font("Arial", Font.BOLD, 24));
				}

				else if (tamanho >= 22) {
					entrada.setFont(new Font("Arial", Font.BOLD, 28));
				}

				else if (tamanho >= 19) {
					entrada.setFont(new Font("Arial", Font.BOLD, 32));
				}

				else if (tamanho >= 18) {
					entrada.setFont(new Font("Arial", Font.BOLD, 36));
				}

				else if (tamanho >= 16) {
					entrada.setFont(new Font("Arial", Font.BOLD, 38));
				}

				else if (tamanho >= 13) {
					entrada.setFont(new Font("Arial", Font.BOLD, 42));
				}

				else if (tamanho == 12) {
					entrada.setFont(new Font("Arial", Font.BOLD, 45));
				} else {
					entrada.setFont(new Font("Arial", Font.BOLD, 48));
				}
				digitosArray.add("aFonte");

			} else {
				tamanho = entrada.getText().length();

				if (tamanho >= 40) {
					entrada.setFont(new Font("Arial", Font.BOLD, 19));
				}

				else if (tamanho >= 34) {
					entrada.setFont(new Font("Arial", Font.BOLD, 20));
				}

				else if (tamanho >= 27) {
					entrada.setFont(new Font("Arial", Font.BOLD, 24));
				}

				else if (tamanho >= 25) {
					entrada.setFont(new Font("Arial", Font.BOLD, 28));
				}

				else if (tamanho >= 22) {
					entrada.setFont(new Font("Arial", Font.BOLD, 32));
				}

				else if (tamanho >= 21) {

					entrada.setFont(new Font("Arial", Font.BOLD, 36));
				}

				else if (tamanho >= 19) {
					entrada.setFont(new Font("Arial", Font.BOLD, 38));
				}

				else if (tamanho >= 16) {
					entrada.setFont(new Font("Arial", Font.BOLD, 42));
				}

				else if (tamanho == 15) {
					entrada.setFont(new Font("Arial", Font.BOLD, 45));
				} else {
					entrada.setFont(new Font("Arial", Font.BOLD, 48));
				}
				digitosArray.add("aFonte");
			}
		}// F-I-M algoritmoNums

	}// F-I-M ButtonHandler
		// private class KeyHandler{

} // fim classef