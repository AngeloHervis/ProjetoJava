import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.*;
import services.*;
import util.*;

public class Main {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<Emprestimo> emprestimos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        CadastroUsuario cadastroUsuario = new CadastroUsuario();

        boolean sair = false;
        while (!sair) {
            Menu.exibirMenuPrincipal();
            int opcao = Menu.lerOpcao();

            switch (opcao) {
                case 1:
                    Livro livro = CadastroLivros.criarLivro(scanner);
                    if (livro != null) {
                        livros.add(livro);
                    }
                    break;
                case 2:
                    PesquisaLivros.pesquisarLivro(livros, scanner);
                    break;
                case 3:
                    Usuario usuario = cadastroUsuario.criarUsuario(scanner);
                    if (usuario != null) {
                        usuarios.add(usuario);
                    }
                    break;
                case 4:
                    EmprestimoLivros.realizarEmprestimo(livros, usuarios, emprestimos, scanner);
                    break;
                case 5:
                    DevolucaoLivros devolucaoLivros = new DevolucaoLivros();
                    for (Emprestimo emprestimo : emprestimos) {
                        devolucaoLivros.devolverLivro(emprestimo, emprestimos, livros);
                    }
                    break;

                case 6:
                    Menu.exibirMenuRelatorios();
                    int opcaoRelatorios = Menu.lerOpcao();
                    Relatorios relatorios = new Relatorios();
                    switch (opcaoRelatorios) {
                        case 1:
                            relatorios.relatorioLivrosEmprestados(emprestimos);
                            break;
                        case 2:
                            relatorios.relatorioUsuariosComAtrasos(emprestimos);
                            break;
                        case 3:
                            relatorios.relatorioLivrosMaisPopulares(emprestimos);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
        scanner.close();
    }
}
