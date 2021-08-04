package br.com.triersistemas.validapessoa;

import java.math.BigDecimal;

public class PessoaFisica extends Pessoa {

	public PessoaFisica(String documento) {
		super(documento);
	}

	@Override
	public Boolean verificar() {
		char[] documento = getDocumento().toCharArray();
		Long digito = Long.valueOf(Integer.valueOf(String.valueOf(documento[9])));	
		Long segundoDigito = Long.valueOf(Integer.valueOf(String.valueOf(documento[10])));
		
		if(retornaDigito().equals(BigDecimal.valueOf(digito)) &&
		   retornaSegundoDigito().equals(BigDecimal.valueOf(segundoDigito))) {
			return true;
		} else {
			return true;
		}		
	}

	@Override
	public String gerarDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatarDocumento() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private BigDecimal retornaDigito() {
		char[] documento = getDocumento().toCharArray();
		Long total = Long.valueOf(0);
		BigDecimal calc= BigDecimal.valueOf(0);		
	
		
		for(int i = 8; i > -1; i--) {			
			total += (i+1) * Integer.valueOf(String.valueOf(documento[i]));
		}
		
		calc = calc.add(BigDecimal.valueOf(total));
		calc = calc.remainder(BigDecimal.valueOf(11));
		
		if(calc.equals(BigDecimal.valueOf(10))) {
			calc = BigDecimal.valueOf(0);
		}
		
		return calc;
	}
	
	private BigDecimal retornaSegundoDigito() {
		char[] documento = getDocumento().toCharArray();
		Long total = Long.valueOf(0);
		BigDecimal calc= BigDecimal.valueOf(0);		
	
		
		for(int i = 9; i > -1; i--) {			
			total += i * Integer.valueOf(String.valueOf(documento[i]));
		}
		
		calc = calc.add(BigDecimal.valueOf(total));
		calc = calc.remainder(BigDecimal.valueOf(11));
		
		if(calc.equals(BigDecimal.valueOf(10))) {
			calc = BigDecimal.valueOf(0);
		}
		
		return calc;
	}
	
}
