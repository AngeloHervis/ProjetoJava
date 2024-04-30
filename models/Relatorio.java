package models;

import java.util.List;

public class Relatorio {
    // Método para gerar relatório de livros emprestados
    public void gerarRelatorioLivrosEmprestados(List<Emprestimo> emprestimos) {
        System.out.println("Relatório de Livros Emprestados:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
            System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
            System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucaoPrevista());
            System.out.println("----------------------------------");
        }
    }

    // Método para gerar relatório de usuários com atrasos
    public void gerarRelatorioUsuariosComAtrasos(List<Emprestimo> emprestimos) {
        System.out.println("Relatório de Usuários com Atrasos:");
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtrasado()) {
                System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
                System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucaoPrevista());
                System.out.println("----------------------------------");
            }
        }
    }

    // Outros métodos de relatório podem ser adicionados conforme necessário
}
