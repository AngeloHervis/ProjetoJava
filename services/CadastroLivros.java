package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Livro;

public class CadastroLivros {
    private List<Livro> livros;

    public CadastroLivros() {
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }
    

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> livrosDoAutor = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosDoAutor.add(livro);
            }
        }
        return livrosDoAutor;
    }

    public static Livro criarLivro(Scanner scanner) {
        System.out.println("Cadastro de Livro");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicação: ");
        int anoPublicacao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Número de Exemplares Disponíveis: ");
        int numExemplaresDisponiveis = scanner.nextInt();
        scanner.nextLine();

        return new Livro(codigo, titulo, autor, anoPublicacao, numExemplaresDisponiveis);
    }
}
