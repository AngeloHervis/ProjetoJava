package services;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import models.Emprestimo;
import models.Livro;
import models.Usuario;

public class EmprestimoLivros {
    // Método para realizar o empréstimo de um livro
    public static Emprestimo emprestarLivro(Livro livro, Usuario usuario, List<Emprestimo> emprestimos) {
        // Verifica se o usuário já possui um livro emprestado
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                System.out.println("Usuário já possui um livro emprestado. Empréstimo não realizado.");
                return null;
            }
        }

        // Verifica se há exemplares disponíveis do livro
        if (livro.getQuantidadeDisponivel() <= 0) {
            System.out.println("Não há exemplares disponíveis deste livro. Empréstimo não realizado.");
            return null;
        }

        // Cria um novo empréstimo
        Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, LocalDate.now(), LocalDate.now().plusDays(7));

        // Atualiza a quantidade de exemplares disponíveis do livro
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);

        // Adiciona o empréstimo à lista de empréstimos
        emprestimos.add(novoEmprestimo);

        System.out.println("Livro emprestado com sucesso!");
        return novoEmprestimo;
    }

    // Método para realizar o empréstimo de um livro interagindo com o usuário
    public static Emprestimo realizarEmprestimo(List<Livro> livros, List<Usuario> usuarios,
            List<Emprestimo> emprestimos, Scanner scanner) {
        // Exibe a lista de livros disponíveis
        System.out.println("Livros Disponíveis:");
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo());
        }

        // Solicita ao usuário o título do livro a ser emprestado
        System.out.print("Digite o título do livro que deseja emprestar: ");
        String tituloLivro = scanner.nextLine();

        // Busca o livro pelo título
        Livro livroSelecionado = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                livroSelecionado = livro;
                break;
            }
        }

        // Se o livro não for encontrado, exibe uma mensagem e retorna null
        if (livroSelecionado == null) {
            System.out.println("Livro não encontrado.");
            return null;
        }

        // Solicita ao usuário o ID do usuário que está realizando o empréstimo
        System.out.print("Digite o ID do usuário que está realizando o empréstimo: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        // Busca o usuário pelo ID
        Usuario usuarioSelecionado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
                usuarioSelecionado = usuario;
                break;
            }
        }

        // Se o usuário não for encontrado, exibe uma mensagem e retorna null
        if (usuarioSelecionado == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }

        // Realiza o empréstimo do livro e retorna o objeto Emprestimo
        // Ajuste na chamada do método emprestarLivro
        return emprestarLivro(livroSelecionado, usuarioSelecionado, emprestimos);
    }
}
