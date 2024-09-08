package utils;

import entities.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClienteUtils {

    private static final Map<String, Cliente> clientes = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);

    public static Map<String, Cliente> getClientesMap() {
        return clientes;
    }

    public static void adicionarCliente() {
        try {
            String nome;
            String numeroDeTelefone;
            String email;

            System.out.print("Digite seu nome: ");
            nome = sc.nextLine();
            System.out.print("Digite seu telefone: ");
            numeroDeTelefone = sc.nextLine();
            System.out.print("Digite seu email: ");
            email = sc.nextLine();

            if (nome.isEmpty() || numeroDeTelefone.isEmpty() || email.isEmpty()) {
                System.out.println("-----------------------------------------------------------------");
                throw new Exception("Todos os campos (nome, telefone e e-mail) devem ser preenchidos.");
            }

            if (clientes.containsKey(numeroDeTelefone)) {
                System.out.println("-------------------------------------");
                throw new Exception("Numero digitado já está sendo usado.");
            }

            Cliente cliente = new Cliente(nome, numeroDeTelefone, email);

            clientes.put(numeroDeTelefone, cliente);
            System.out.println("------------------------------");
            System.out.println("Contato Adicionado com sucesso");
            System.out.println("------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente removerCliente() {
        Cliente clienteRemovido = null;
        try {
            System.out.println("Digite o numero de contato para excluir: ");
            String numeroDeTelefone = sc.nextLine();

            if (!clientes.containsKey(numeroDeTelefone)) {
                System.out.println("---------------------------");
                throw new Exception("Contato:" + numeroDeTelefone + " Não foi encontrado. ");
            }
            clienteRemovido = clientes.remove(numeroDeTelefone);
            System.out.println("---------------------------");
            System.out.println("Contato removido com sucesso!");
            System.out.println("---------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clienteRemovido;
    }

    public static void editarContato() {
        try {
            System.out.print("Digite o telefone do contato que deseja editar: ");
            String numeroDeTelefone = sc.nextLine();

            Cliente cliente = clientes.get(numeroDeTelefone);
            if (cliente == null) {
                System.out.println("---------------------------");
                throw new Exception("Contato: " + numeroDeTelefone + " não encontrado");
            }

            System.out.print("Digite o novo nome (ou pressione Enter para manter o atual): ");
            String novoNome = sc.nextLine();
            if (!novoNome.isEmpty()) {
                cliente.setNome(novoNome);
            }

            System.out.print("Digite o novo e-mail (ou pressione Enter para manter o atual): ");
            String novoEmail = sc.nextLine();
            if (!novoEmail.isEmpty()) {
                cliente.setEmail(novoEmail);
            }

            System.out.print("Digite o novo número de telefone (ou pressione Enter para manter o atual): ");
            String novoNumeroDeTelefone = sc.nextLine();

            if (!novoNumeroDeTelefone.isEmpty() && !novoNumeroDeTelefone.equals(numeroDeTelefone)) {
                if (clientes.containsKey(novoNumeroDeTelefone)) {
                    System.out.println("---------------------------");
                    throw new Exception("Número de telefone já cadastrado. Atualização não realizada.");
                }

                clientes.remove(numeroDeTelefone);
                clientes.put(novoNumeroDeTelefone, cliente);
                System.out.println("---------------------------");
                System.out.println("Número de telefone atualizado com sucesso.");
                System.out.println("---------------------------");
            } else {
                clientes.put(numeroDeTelefone, cliente);
                System.out.println("---------------------------");
                System.out.println("Contato atualizado com sucesso.");
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void detalharCliente() {
        try {
            System.out.print("Digite o número do contato que deseja ver os detalhes: ");
            String numeroDeTelefone = sc.nextLine();
            Cliente cliente = clientes.get(numeroDeTelefone);

            if (cliente == null) {
                System.out.println("---------------------------");
                throw new Exception("Contato não encontrado");
            }

            System.out.println("---------------------------");
            System.out.println("Nome: " + cliente.getNome()
                    + " | Telefone: " + numeroDeTelefone
                    + " | Email: " + cliente.getEmail());
            System.out.println("---------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("Cadastro de clientes está vazio");
            System.out.println("-------------------------------");
            return;
        }
        for (Map.Entry<String, Cliente> contato : clientes.entrySet()) {
            Cliente cliente = contato.getValue();
            System.out.println("---------------------------");
            System.out.println("Nome: " + cliente.getNome()
                    + " | Telefone: " + contato.getKey()
                    + " | Email: " + cliente.getEmail());
            System.out.println("---------------------------");
        }
    }
}