package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Usuario;

public class CadastroUsuario {
    private List<Usuario> usuarios;

    public CadastroUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario criarUsuario(Scanner scanner) {
        System.out.println("Informe os dados do usuário:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Usuario(nome, telefone, endereco, email);
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null; 
    }
}
