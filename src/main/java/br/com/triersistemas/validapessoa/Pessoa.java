package br.com.triersistemas.validapessoa;

public abstract class Pessoa {

	private String documento;
	
	public Pessoa(String documento) {
		this.documento = documento;
	}
	
	public abstract Boolean verificar();
	public abstract String gerarDocumento();
	public abstract String formatarDocumento();
	
	public String getDocumento() {
		return documento;
	}
	
}
