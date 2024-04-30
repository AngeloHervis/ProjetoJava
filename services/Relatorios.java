package services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.Emprestimo;
import models.Livro;
import models.Usuario;

public class Relatorios {
    // Método para gerar relatório de livros emprestados
    public void relatorioLivrosEmprestados(List<Emprestimo> emprestimos) {
        System.out.println("Relatório de Livros Emprestados:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
            System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
            System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucaoPrevista());
            System.out.println("-----------------------------------");
        }
    }

    // Método para gerar relatório de usuários com atrasos
    public void relatorioUsuariosComAtrasos(List<Emprestimo> emprestimos) {
        System.out.println("Relatório de Usuários com Atrasos:");
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataDevolucaoPrevista().isBefore(emprestimo.getDataDevolucaoEfetiva())) {
                System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
                System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucaoPrevista());
                System.out.println("Data de Devolução Efetiva: " + emprestimo.getDataDevolucaoEfetiva());
                System.out.println("-----------------------------------");
            }
        }
    }

    // Método para gerar relatório de histórico de empréstimos por usuário
    public void relatorioHistoricoEmprestimosPorUsuario(List<Emprestimo> emprestimos, Usuario usuario) {
        System.out.println("Relatório de Histórico de Empréstimos para o Usuário " + usuario.getNome() + ":");
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
                System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucaoPrevista());
                System.out.println("Status: " + (emprestimo.getDataDevolucaoEfetiva().isAfter(emprestimo.getDataDevolucaoPrevista()) ? "Em Atraso" : "Devolvido"));
                System.out.println("-----------------------------------");
            }
        }
    }

    // Método para gerar relatório de usuários por critério (exemplo: comprimento do nome)
    public void relatorioUsuariosPorCriterio(List<Usuario> usuarios) {
        System.out.println("Relatório de Usuários por Critério:");
        Map<Integer, List<Usuario>> usuariosPorCriterio = usuarios.stream()
                                                            .collect(Collectors.groupingBy(usuario -> usuario.getNome().length()));
        usuariosPorCriterio.forEach((criterio, listaUsuarios) -> {
            System.out.println("Criterio: " + criterio);
            System.out.println("Quantidade de Usuários: " + listaUsuarios.size());
            System.out.println("-----------------------------------");
        });
    }

    public void relatorioLivrosMaisPopulares(List<Emprestimo> emprestimos) {
    System.out.println("Relatório de Livros Mais Populares:");
    Map<Livro, Long> contadorLivros = emprestimos.stream()
                                    .collect(Collectors.groupingBy(Emprestimo::getLivro, Collectors.counting()));
    contadorLivros.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
        .limit(5)
        .forEach(entry -> {
            System.out.println("Livro: " + entry.getKey().getTitulo());
            System.out.println("Quantidade de Empréstimos: " + entry.getValue());
            System.out.println("-----------------------------------");
        });
    }
}


