package br.com.camilasantos.biblioteca.model;

import br.com.camilasantos.biblioteca.enums.Status;
import br.com.camilasantos.biblioteca.exception.ErrorException;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private Status status;
	
	public Livro(String titulo, String autor, int id) {
		this.titulo = titulo;
		this.autor = autor;
		this.status = Status.DISPONIVEL;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
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
	
	public void emprestar() throws ErrorException {
		if(this.status != Status.DISPONIVEL) {
			throw new ErrorException("fail: livro não disponivel");
		}
		this.status = Status.EMPRESTADO;
	}
	
	public void devolver(){
	
		this.status = Status.DISPONIVEL;
	}
	//public void setStatus() {
	//	this.status = Status.EMPRESTADO;
	//	return;
	//}
	
	public String toString() {
		return getId() + " " + getTitulo() + ": " + getAutor() + " - " + getStatus();
	}
}
