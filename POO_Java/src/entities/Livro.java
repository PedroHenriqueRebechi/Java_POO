package entities;

public class Livro {
	private String titulo;
	private Integer anoPublicacao;
	
	public Livro(String titulo, Integer anoPublicacao) {
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public String toString() {
		return "Título: "
				+ titulo
				+ " ("
				+ anoPublicacao
				+ ")";
	}
}
