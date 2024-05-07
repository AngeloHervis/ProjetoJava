package services;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import models.Emprestimo;
import models.Livro;

public class DevolucaoLivros {
    public void devolverLivro(Emprestimo emprestimo, List<Emprestimo> emprestimos, List<Livro> livros) {
        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado. Devolução não realizada.");
            return;
        }

        Iterator<Emprestimo> iterator = emprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo emp = iterator.next();
            if (emp.equals(emprestimo)) {
                iterator.remove();
                break;
            }
        }

        emprestimo.setDataDevolucaoEfetiva(LocalDate.now());

        Livro livro = emprestimo.getLivro();
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + 1);

        System.out.println("Livro devolvido com sucesso!");
    }
}
