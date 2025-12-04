package entities;

public class PessoaJuridica extends Pessoa {
	
	private Integer numeroDeFuncionarios;

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	@Override
	public Double calcularImpostoDeRenda() {
		double imposto = 0;
		
		if (numeroDeFuncionarios > 10) {
			imposto = 0.14;
		} else {
			imposto = 0.16;
		}
		
		return super.getRendaAnual() * imposto;
	}
}
