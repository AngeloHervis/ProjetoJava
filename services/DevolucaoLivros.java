package services;

import java.time.LocalDate;
import java.util.List;
import models.Emprestimo;
import models.Livro;

public class DevolucaoLivros {
    // Método para realizar a devolução de um livro
    public void devolverLivro(Emprestimo emprestimo, List<Livro> livros) {
        // Verifica se o empréstimo existe
        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado. Devolução não realizada.");
            return;
        }

        // Remove o empréstimo da lista
        livros.add(emprestimo.getLivro());

        // Atualiza a data de devolução efetiva
        emprestimo.setDataDevolucaoEfetiva(LocalDate.now());

        System.out.println("Livro devolvido com sucesso!");
    }
}
