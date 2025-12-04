package entities;

public class PessoaFisica extends Pessoa{
	
	private Double gastosComSaude;

	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}
	
	@Override
	public Double calcularImpostoDeRenda() {
		double imposto = 0;
		
		if (super.getRendaAnual() < 20000.0) {
			imposto = 0.15;
		} else {
			imposto = 0.25;
		}
		
		if (gastosComSaude > 0) {
			
			return (super.getRendaAnual() * imposto)  - (gastosComSaude * 0.5);
		
		} else {
		
			return (super.getRendaAnual() * imposto);
		
		}
		
	}
}
