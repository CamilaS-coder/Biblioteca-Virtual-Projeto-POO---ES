package br.com.camilasantos.biblioteca.model;

import br.com.camilasantos.biblioteca.enums.Status;

public class Livro {
	private String titulo;
	private String autor;
	private Status status;
	
	public Livro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.status = Status.DISPONIVEL;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public void setStatus() {
		this.status = Status.EMPRESTADO;
		return;
	}
	
	public String toString() {
		return getTitulo() + ": " + getAutor() + " - " + getStatus();
	}
}
