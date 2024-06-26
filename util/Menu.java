package util;

import java.util.Scanner;

public class Menu {
    public static void exibirMenuPrincipal() {
        System.out.println("=== Biblioteca - Menu Principal ===");
        System.out.println("1. Cadastro de Livros");
        System.out.println("2. Pesquisa de Livros");
        System.out.println("3. Cadastro de Usuários");
        System.out.println("4. Empréstimo de Livros");
        System.out.println("5. Devolução de Livros");
        System.out.println("6. Relatórios");
        System.out.println("0. Sair");
    }

    public static void exibirMenuRelatorios() {
        System.out.println("=== Relatórios ===");
        System.out.println("1. Livros Emprestados");
        System.out.println("2. Usuários com Atrasos");
        System.out.println("3. Livros Mais Populares");
        System.out.println("0. Voltar ao Menu Principal");
    }

    public static int lerOpcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha uma opção: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            System.out.print("Escolha uma opção: ");
            scanner.next();
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
}
