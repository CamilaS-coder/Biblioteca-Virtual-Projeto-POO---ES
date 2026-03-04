package br.com.camilasantos.biblioteca.service;
import java.util.ArrayList;

import br.com.camilasantos.biblioteca.exception.ErrorException;
//import br.com.camilasantos.biblioteca.model.Funcionario;
import br.com.camilasantos.biblioteca.model.Aluno;
import br.com.camilasantos.biblioteca.model.Emprestimo;
import br.com.camilasantos.biblioteca.model.Usuario;
import br.com.camilasantos.biblioteca.model.Livro;

public interface BibliotecaService {
	public static final ArrayList<Livro> livros = new ArrayList<Livro>();
	public static final ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static final ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
	
	
	//public abstract void cadastrarLivro(Funcionario funcionario, Aluno aluno);
	public abstract void cadastrarLivro(String titulo, String autor); //cadastrar livro no acervo da biblioteca;
	public abstract void cadastrarAluno(Aluno aluno); //cadastrar aluno nos registrod da biblioteca;
	public abstract ArrayList<Emprestimo> realizarEmprestimo(int idUsuario, int idLivro) throws ErrorException; //emprestar livro para funcionario ou aluno
	public abstract ArrayList<Livro> listarlivrosEmprestados(int idUsuario) throws ErrorException;
	public abstract ArrayList<Livro> realizarDevolucao(Livro livro);// retirar o livro da lista do aluno, mas deixar uma especie de histórico
	//ArrayList<Livro> cadastrarLivro(Livro livro);
	//void cadastrarLivro(String titulo, String autor);
}
