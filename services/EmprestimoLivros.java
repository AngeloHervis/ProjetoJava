package services;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import models.Emprestimo;
import models.Livro;
import models.Usuario;

public class EmprestimoLivros {

    public static Emprestimo realizarEmprestimo(List<Livro> livros, List<Usuario> usuarios, List<Emprestimo> emprestimos, Scanner scanner) {
        System.out.println("Livros Disponíveis:");
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo());
        }

        System.out.print("Digite o título do livro que deseja emprestar: ");
        String tituloLivro = scanner.nextLine();

        Livro livroSelecionado = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                livroSelecionado = livro;
                break;
            }
        }

        if (livroSelecionado == null) {
            System.out.println("Livro não encontrado.");
            return null;
        }

        if (livroSelecionado.getQuantidadeDisponivel() <= 0) {
            System.out.println("Não há exemplares disponíveis deste livro. Empréstimo não realizado.");
            return null;
        }

        System.out.print("Digite o nome completo do usuário que está realizando o empréstimo: ");
        String nomeUsuario = scanner.nextLine();

        Usuario usuarioSelecionado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuarioSelecionado = usuario;
                break;
            }
        }

        if (usuarioSelecionado == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuarioSelecionado)) {
                System.out.println("Usuário já possui um livro emprestado. Empréstimo não realizado.");
                return null;
            }
        }

        return emprestarLivro(livroSelecionado, usuarioSelecionado, emprestimos);
    }

    private static Emprestimo emprestarLivro(Livro livro, Usuario usuario, List<Emprestimo> emprestimos) {
        if (livro.getQuantidadeDisponivel() <= 0) {
            System.out.println("Não há exemplares disponíveis deste livro. Empréstimo não realizado.");
            return null;
        }

        Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, LocalDate.now(), LocalDate.now().plusDays(7));
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1); // Atualiza a quantidade disponível
        emprestimos.add(novoEmprestimo);

        System.out.println("Livro emprestado com sucesso!");
        return novoEmprestimo;
    }
}
