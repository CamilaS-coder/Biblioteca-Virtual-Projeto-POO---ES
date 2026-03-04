package br.com.camilasantos.biblioteca;

import java.util.Scanner;

import br.com.camilasantos.biblioteca.exception.ErrorException;
import br.com.camilasantos.biblioteca.service.Biblioteca;

public class Principal {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Realizar empréstimo");
            System.out.println("4 - Realizar devolução");
            System.out.println("5 - Mostrar sustema da biblioteca");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try {
                switch (opcao) {

                    case 1:
                        //System.out.print("Digite o id do usuário: ");
                        //int idUsuario = sc.nextInt();
                        //sc.nextLine();
                        System.out.print("Digite o nome do usuário: ");
                        String nomeUsuario = sc.nextLine();
                        biblioteca.cadastrarAluno( nomeUsuario);
                        break;

                    case 2:
                    	System.out.print("Digite o título do livro: ");
                    	String tituloLivro = sc.nextLine();

                    	System.out.print("Digite o autor do livro: ");
                    	String autorLivro = sc.nextLine();

                    	biblioteca.cadastrarLivro(tituloLivro, autorLivro);
                    	break;

                    case 3:
                        System.out.print("Digite o id do usuário: ");
                        int idEmpUsuario = sc.nextInt();
                        System.out.print("Digite o id do livro: ");
                        int idEmpLivro = sc.nextInt();
                        biblioteca.realizarEmprestimo(idEmpUsuario, idEmpLivro);
                        break;

                    case 4:
                        System.out.print("Digite o id do usuário: ");
                        int idDevUsuario = sc.nextInt();
                        System.out.print("Digite o id do livro: ");
                        int idDevLivro = sc.nextInt();
                        biblioteca.realizarDevolucao(idDevUsuario, idDevLivro);
                        break;

                    case 5:
                        System.out.println(biblioteca);
                        break;

                    case 0:
                        System.out.println("Encerrando sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (ErrorException e) {
                System.out.println(e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}