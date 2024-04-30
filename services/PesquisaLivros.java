package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Livro;

public class PesquisaLivros {
    // Método para buscar livro por código
    public Livro buscarLivroPorCodigo(List<Livro> livros, int codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    // Método para buscar livros por título
    public List<Livro> buscarLivrosPorTitulo(List<Livro> livros, String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados; // Retorna uma lista vazia se nenhum livro for encontrado
    }

    // Método para buscar livros por autor
    public List<Livro> buscarLivrosPorAutor(List<Livro> livros, String autor) {
        List<Livro> livrosDoAutor = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                livrosDoAutor.add(livro);
            }
        }
        return livrosDoAutor; // Retorna uma lista vazia se nenhum livro do autor for encontrado
    }

    // Método para buscar livros por categoria
    public List<Livro> buscarLivrosPorCategoria(List<Livro> livros, String categoria) {
        List<Livro> livrosDaCategoria = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getCategoria().toLowerCase().contains(categoria.toLowerCase())) {
                livrosDaCategoria.add(livro);
            }
        }
        return livrosDaCategoria; // Retorna uma lista vazia se nenhum livro da categoria for encontrado
    }

    public static void pesquisarLivro(List<Livro> livros, Scanner scanner) {
        System.out.print("Informe o título do livro: ");
        String titulo = scanner.nextLine();
        
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Livro encontrado:");
                System.out.println(livro);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }
}
