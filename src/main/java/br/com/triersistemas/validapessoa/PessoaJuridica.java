package br.com.triersistemas.validapessoa;

import java.math.BigDecimal;

public class PessoaJuridica extends Pessoa {

	public PessoaJuridica(String documento) {
		super(documento);
	}
	
	@Override
	public Boolean verificar() {
		char[] documento = getDocumento().toCharArray();
		Long digito = Long.valueOf(Integer.valueOf(String.valueOf(documento[12])));	
		Long segundoDigito = Long.valueOf(Integer.valueOf(String.valueOf(documento[13])));
		
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
		String cnpj = super.getDocumento();
		
		cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
		return cnpj;
	}
	
	private BigDecimal retornaDigito() {
		char[] documento = getDocumento().toCharArray();
		Long total = Long.valueOf(0);
		BigDecimal calc= BigDecimal.valueOf(0);		
	
		
		for(int i = 11; i > 3; i--) {	
			total += (i-2) * Integer.valueOf(String.valueOf(documento[i]));
		}
		
		for(int i = 3; i > -1; i--) {	
			total += (i+6) * Integer.valueOf(String.valueOf(documento[i]));
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
		long ultimoCaracter = Long.valueOf(String.valueOf(documento[11])); 
		Long total = Long.valueOf(0);
		BigDecimal calc= BigDecimal.valueOf(0);		
	
		//
		calc = calc.add(retornaDigito().multiply(BigDecimal.valueOf(9)));
		
		for(int i = 11; i > 4; i--) {	
			total += (i-3) * Integer.valueOf(String.valueOf(documento[i]));
		}
		
		for(int i = 4; i > -1; i--) {	
			total += (i+5) * Integer.valueOf(String.valueOf(documento[i]));
		}
		
		calc = calc.add(BigDecimal.valueOf(total));
		calc = calc.remainder(BigDecimal.valueOf(11));
		
		if(calc.equals(BigDecimal.valueOf(10))) {
			calc = BigDecimal.valueOf(0);
		}
		
		return calc;
	}	
}
