package br.com.camilasantos.biblioteca.model;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	
	public Emprestimo (Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
	}
	
	public Livro getLivro() {
		return this.livro;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public String toString() {
		return getUsuario().toString() +  getLivro().toString() + "\n";
	}
	
}
