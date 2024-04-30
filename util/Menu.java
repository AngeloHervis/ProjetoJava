package util;

import java.util.Scanner;

public class Menu {
    // Método para exibir o menu principal
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

    // Método para exibir o menu de relatórios
    public static void exibirMenuRelatorios() {
        System.out.println("=== Relatórios ===");
        System.out.println("1. Livros Emprestados");
        System.out.println("2. Usuários com Atrasos");
        System.out.println("3. Livros Mais Populares");
        System.out.println("0. Voltar ao Menu Principal");
    }

    // Método para ler a opção do usuário
    public static int lerOpcao() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                System.out.print("Escolha uma opção: ");
                scanner.next();
            }
            return scanner.nextInt();
        } finally {
            scanner.close();
        }
    }
}
