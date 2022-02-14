import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

// Calculadora - Análise Combinatória
// Integrantes:
// Gabriel Araújo
// Nicolas Seroiska
// Sayid Safa

public class Calculadora {
	// ---------------------------------------------parte_permutação-----------------------------------------------//
	public BigDecimal permutacao(ArrayList<BigDecimal> recebeArray, ArrayList<String> recebeArrayOp) {

		BigDecimal n = new BigDecimal(0), permuta;

		BigDecimal multiplicacaoFatRepetido = new BigDecimal("1");	
		
		if (recebeArray.size() == 2) {
			for (int i = 0; i < recebeArrayOp.size(); i++) {
				if (recebeArrayOp.get(i) == "p")
					n = recebeArray.get(i - 2);
			}
		} else {
			n = recebeArray.get(0);
		}

		if (recebeArray.size() == 1)
			permuta = n.divide(BigDecimal.valueOf(1));

		permuta = n.divide(multiplicacaoFatRepetido);
		
		return permuta;

	} // fim metodo - log_permutacao

	// --------------------------------------------parte_arranjo------------------------------------------------//

	public BigDecimal arranjo(ArrayList<BigDecimal> recebeArray, ArrayList<String> recebeArrayOp) {

		BigDecimal n, p, arranjo;
		
		n = p = new BigDecimal(1);

		if (recebeArray.size() >= 3) {
			n = recebeArray.get(1);
			p = recebeArray.get(2);
		} else {
			n = recebeArray.get(0);

			p = recebeArray.get(1);
		}
		

		arranjo = fatorial(n).divide(fatorial((n.subtract(p))));
		return arranjo;
	} // fim metodo - arranjo

	// --------------------------------parte_combinação------------------------------------------//

	public BigDecimal combinacao(ArrayList<BigDecimal> recebeArray, ArrayList<String> recebeArrayOp) {
		
		BigDecimal n, p, combinacao;

		n = p = new BigDecimal(1);

		if (recebeArray.size() >= 3) {

			n = recebeArray.get(1);
			p = recebeArray.get(2);
		} else {
			n = recebeArray.get(0);

			p = recebeArray.get(1);
		}
		
		combinacao = fatorial(n).divide((fatorial(p).multiply((fatorial(n.subtract(p))))));
		
		
		return combinacao;

	} // fim metodo - combinacao
	
	
	// --------------------------------parte_logaritmo------------------------------------------//
	public BigDecimal logaritmo(ArrayList<BigDecimal> recebeArray, ArrayList<String> recebeArrayOp) {
		
		BigDecimal n, p, logaritmo;

		n = p = new BigDecimal(1);

		if (recebeArray.size() >= 3) {

			n = recebeArray.get(1);
			p = recebeArray.get(2);
		} else {
			n = recebeArray.get(0);

			p = recebeArray.get(1);
		}
		
		
		logaritmo = new BigDecimal(Math.log(n.doubleValue()) / Math.log(p.doubleValue()));
		
		return logaritmo;

	} // fim metodo - log
	
	// --------------------------------parte_potencia------------------------------------------//
	
	public BigDecimal potencia(ArrayList<BigDecimal> recebeArray, ArrayList<String> recebeArrayOp) {

		BigDecimal n, p, potencia;

		n = p = new BigDecimal(1);

		if (recebeArray.size() >= 3) {

			n = recebeArray.get(1);
			p = recebeArray.get(2);
		} 
		else {
			n = recebeArray.get(0);

			p = recebeArray.get(1);
		}
		
		potencia = n.pow(p.intValue());
		
		return potencia;

	} // fim metodo - pot
	
	// --------------------------------parte_exponencial------------------------------------------//
	
		public BigDecimal exponencial(ArrayList<BigDecimal> recebeArray, ArrayList<String> recebeArrayOp) {

			BigDecimal n, p, exponencial;

			String acumula;
			
			n = p = new BigDecimal(1);

			if (recebeArray.size() >= 3) {

				n = recebeArray.get(1);
				p = recebeArray.get(2);
			} 
			else {
				n = recebeArray.get(0);

				p = recebeArray.get(1);
			}
			
			if(p.intValue() == 0)
				return new BigDecimal(0);
			
			acumula = String.valueOf(n);
			
			for(int i = 0; i < p.intValue(); i++) {
				acumula = acumula + "0";
			}
		
			exponencial = new BigDecimal(acumula);
			
			return exponencial;

		} // fim metodo - Exponencial
	
	public String verificaEx (ArrayList<String> recebeArray, ArrayList<String> recebeArrayOp) {
		
		String existe = null;
		
		String verificaSinal = "";
		
		ArrayList<Double> recebeArrayDouble = new ArrayList<>();
		
		for (int i = 0; i < recebeArray.size(); i++) {
			
			
			verificaSinal = recebeArray.get(i);
			
			recebeArrayDouble.add(Double.parseDouble(verificaSinal));
		}
		
		if(recebeArrayOp.get(1) == "/" && recebeArrayDouble.get(1) == 0.0) {
			existe = "exDivisaoPorZero";
		}
		
		else if(recebeArrayOp.get(1) == "1/" && recebeArrayDouble.get(0) == 0.0) {
			existe = "exDivisaoPorZero";
		}
		
		else if(recebeArrayOp.get(1) == "A" && recebeArrayDouble.get(1) == 0.0) {
			existe = "exDivisaoPorZero";
		}
		
		else if(recebeArrayOp.get(1) == "C" && recebeArrayDouble.get(1) > recebeArrayDouble.get(0)) {
			existe = "exDivisaoPorZero";
		}
		
		else if(recebeArrayOp.get(1) == "A" && recebeArrayDouble.get(1) == 0.0) {
			existe = "exDivisaoPorZero";
		}
		
		else if(recebeArrayOp.get(1) == "C" && recebeArrayDouble.get(1) > recebeArrayDouble.get(0)) {
			existe = "exDivisaoPorZero";
		}
		
		else if (recebeArrayOp.get(1) == "p" && recebeArrayDouble.get(0) == 0.0) {
			existe = "exDivisaoPorZero";
		}
		
		
		return existe;
		
	}
	
	// --------------------------------verifica se eh uma das operacoes especiais abaixo------------------------------------------//
	public BigDecimal verifica(ArrayList<String> recebeArray, ArrayList<String> recebeArrayOp) {

		if(recebeArrayOp.get(1) == "n") {
			recebeArrayOp.remove(0);
		}
		
		BigDecimal resultado;

		boolean par;
		String verifica;
		par = false;
		verifica = "nao";

		ArrayList<BigDecimal> recebeArrayBg = new ArrayList<>();
		ArrayList<BigDecimal> recebeArrayBgAt = new ArrayList<>();

		for (int i = 0; i < recebeArray.size(); i++)
			recebeArrayBg.add(new BigDecimal(recebeArray.get(i)));

		for (int i = 0; i < recebeArrayOp.size(); i++) {

			if (i % 2 == 0) {
				par = true;
			} else {
				par = false;
			}
			if (recebeArrayOp.get(i) == "A") {
				
				recebeArrayBgAt.add(recebeArrayBg.get(i / 2));
				recebeArrayBgAt.add(recebeArrayBg.get(i / 2 + 1));
				verifica = "sim";
			
			}
			else if (recebeArrayOp.get(i) == "C") {
				
				recebeArrayBgAt.add(recebeArrayBg.get(i / 2));
				recebeArrayBgAt.add(recebeArrayBg.get(i / 2 + 1));
			
				verifica = "sim";
			} 
			
			else if (recebeArrayOp.get(i) == "log") {
				
				recebeArrayBgAt.add(recebeArrayBg.get(i / 2));
				recebeArrayBgAt.add(recebeArrayBg.get(i / 2 + 1));
				
				verifica = "sim";
			}
			
			else if (recebeArrayOp.get(i) == "exp") {
				
				recebeArrayBgAt.add(recebeArrayBg.get(i / 2));
				recebeArrayBgAt.add(recebeArrayBg.get(i / 2 + 1));

				verifica = "sim";
			}
			
			
			else if (recebeArrayOp.get(i) == "P") {
				
				if (par == true)
					recebeArrayBgAt.add(fatorial(recebeArrayBg.get(i / 2 - 1)));

				else
					recebeArrayBgAt.add(fatorial(recebeArrayBg.get(i / 2))); // arredonda pra baixo --> gambiarra com numero inteiro

				verifica = "sim";
			}

			else if (recebeArrayOp.get(i) == "fat") {
				if (par == true)
					recebeArrayBgAt.add(fatorial(recebeArrayBg.get(i / 2 - 1)));

				else
					recebeArrayBgAt.add(fatorial(recebeArrayBg.get(i / 2))); // arredonda pra baixo --> gambiarra com numero inteiro

				verifica = "sim";
			} 
			
			else if (recebeArrayOp.get(i) == "1/") {
				if (par == true)
					recebeArrayBgAt.add(new BigDecimal(1).divide((recebeArrayBg.get(i / 2 - 1))));

				else
					recebeArrayBgAt.add(new BigDecimal(1).divide(recebeArrayBg.get(i / 2))); // arredonda pra baixo --> gambiarra com numero inteiro
				verifica = "sim";
			}
			
			else if (recebeArrayOp.get(i) == "ln") {
				if (par == true)
					recebeArrayBgAt.add(new BigDecimal(Math.log(recebeArrayBg.get(i / 2 - 1).doubleValue())));

				else
					recebeArrayBgAt.add(new BigDecimal(Math.log(recebeArrayBg.get(i / 2).doubleValue()))); // arredonda pra baixo --> gambiarra com numero inteiro

				verifica = "sim";
			} 
			
			else if (i >= 1 && verifica == "nao") 
				try {
					recebeArrayBgAt.add(recebeArrayBg.get(i - 1));
				}
				catch(IndexOutOfBoundsException e) {
					recebeArrayBgAt.add(new BigDecimal(0));
					recebeArrayBgAt.add(recebeArrayBg.get(i - 2));
				}
		}
		
		resultado = operacoes(recebeArrayBgAt, recebeArrayOp);
		
		return resultado;

	}//fim metodo verifica
	
	// --------------------------------faz o restante das operacoes------------------------------------------//
	public BigDecimal operacoes(ArrayList<BigDecimal> recebeArray, ArrayList<String> recebeArrayOp) {

		BigDecimal resultado = new BigDecimal(0);
		if (recebeArray.size() == 4) {
			recebeArray.remove(1);
		}

		boolean acao = false;

		for (int i = 0; i < recebeArrayOp.size(); i++) {
			if (recebeArrayOp.get(i) == "A") {
				resultado = arranjo(recebeArray, recebeArrayOp);
				acao = true;
			}

			else if (recebeArrayOp.get(i) == "C") {
				resultado = combinacao(recebeArray, recebeArrayOp);
				acao = true;
			}
			
			else if (recebeArrayOp.get(i) == "log") {
				resultado = logaritmo(recebeArray, recebeArrayOp);
				acao = true;
			}
			
			else if (recebeArrayOp.get(i) == "exp") {
				resultado = exponencial(recebeArray, recebeArrayOp);
				acao = true;
			}
			
			else if (recebeArrayOp.get(i) == "^") {
				resultado = potencia(recebeArray, recebeArrayOp);
				acao = true;
			} 
			else if (recebeArrayOp.get(i) == "P") {
				resultado = recebeArray.get(i - 1);
				acao = true;
			}
			else if (recebeArrayOp.get(i) == "fat") {
				resultado = recebeArray.get(i - 1);
				acao = true;
			}
			else if (recebeArrayOp.get(i) == "1/") {
				resultado = recebeArray.get(i - 1);
				acao = true;
			}
			else if (recebeArrayOp.get(i) == "ln") {
				resultado = recebeArray.get(i - 1);
				acao = true;
			}
			
		} 
		for (int i = 0; i < recebeArrayOp.size(); i++) {
			if (recebeArrayOp.get(i) == "+") {

				if (acao == true)
					resultado = recebeArray.get(i - 1).add(resultado);

				else
					resultado = recebeArray.get(i - 1).add(recebeArray.get(i));

			}

			else if (recebeArrayOp.get(i) == "-") {

				if (acao == true)
					resultado = recebeArray.get(i - 1).subtract(resultado);

				else
					resultado = recebeArray.get(i - 1).subtract(recebeArray.get(i));

			}

			else if (recebeArrayOp.get(i) == "x") {
				if (acao == true)
					resultado = recebeArray.get(i - 1).multiply(resultado);

				else
					resultado = recebeArray.get(i - 1).multiply(recebeArray.get(i));

			}
			
			else if (recebeArrayOp.get(i) == "/") {
				if (acao == true)
					resultado = recebeArray.get(i - 1).divide(resultado, MathContext.DECIMAL128);

				else
					resultado = recebeArray.get(i - 1).divide(recebeArray.get(i), MathContext.DECIMAL128);
			}

		}

		return resultado;

	}// fim metodo operacoes

	// ----------------------------------------------------------------------------//

	// calculo do fatorial de um número - metodo interativo
	public BigDecimal fatorial(BigDecimal n) {

		BigDecimal fatorial;

		if (n.equals(new BigDecimal(1)))
			return new BigDecimal(1);

		fatorial = n.multiply(fatorial(n.subtract(new BigDecimal(1))));

		return fatorial;

	}// fim fatorial

}