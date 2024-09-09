package utils;

import entities.*;

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
            String telefone = null;
            String email;
            String categoria;

            System.out.print("Digite seu nome: ");
            nome = sc.nextLine();

                System.out.print("Digite seu telefone: ");
                String tel = sc.nextLine();
                Integer.parseInt(tel);
                telefone = tel;




            System.out.print("Digite seu email: ");
            email = sc.nextLine();

            do {
                System.out.println("Digite o código da sua categoria: ");
                System.out.println("A - VIP");
                System.out.println("B - Estudante");
                System.out.println("C - Funcionário");
                System.out.println("D - Convencional");
                categoria = sc.nextLine().trim().toUpperCase();
                if (!categoria.equals("A") && !categoria.equals("B") && !categoria.equals("C") && !categoria.equals("D")) {
                    System.out.println("Opção inválida.");
                }
            } while (!categoria.equals("A") && !categoria.equals("B") && !categoria.equals("C") && !categoria.equals("D"));
            System.out.println("Categoria escolhida: " + categoria);

            if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                System.out.println("---------------------------------------");
                throw new Exception("Todos os campos devem ser preenchidos.");
            }

            if (clientes.containsKey(telefone)) {
                System.out.println("-------------------------------------");
                throw new Exception("Número digitado já está sendo usado.");
            }

            Cliente cliente = null;
            switch (categoria) {
                case "A" -> cliente = new ClienteVip(nome, telefone, email);
                case "B" -> {
                    System.out.print("Digite sua matricula: ");
                    String matricula = sc.nextLine();
                    cliente = new ClienteEstudante(nome, telefone, email, matricula);
                }
                case "C" -> {
                    System.out.print("Digite seu cargo: ");
                    String cargo = sc.nextLine();
                    cliente = new ClienteFuncionario(nome, telefone, email, cargo);
                }
                case "D" -> cliente = new ClienteDefault(nome, telefone, email);
            }
            clientes.put(telefone, cliente);
            exibirMensagem("Contato adicionado com sucesso.");
        }catch (NumberFormatException e){
            System.out.println(ConsoleColors.RED_BOLD + "O telefone deve ser númerico. " + ConsoleColors.RESET);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exibirMensagem(String mensagem) {
        System.out.println("-".repeat(mensagem.length()));
        System.out.println(mensagem);
        System.out.println("-".repeat(mensagem.length()));
    }

    public static void removerCliente() {
        try {
            System.out.println("Digite o numero de contato para excluir: ");
            String numeroDeTelefone = sc.nextLine();

            if (!clientes.containsKey(numeroDeTelefone)) {
                System.out.println("---------------------------");
                throw new Exception("Contato:" + numeroDeTelefone + " Não foi encontrado. ");
            }
            clientes.remove(numeroDeTelefone);
            exibirMensagem("Contato removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
                exibirMensagem("Número de telefone atualizado com sucesso.");
            } else {
                clientes.put(numeroDeTelefone, cliente);
                exibirMensagem("Contato atualizado com sucesso.");
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

            exibirMensagem("Nome: " + cliente.getNome()
                    + " | Telefone: " + numeroDeTelefone
                    + " | Email: " + cliente.getEmail());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listarClientes() {
        if (clientes.isEmpty()) {
            exibirMensagem("Cadastro de clientes está vazio");
            return;
        }
        for (Map.Entry<String, Cliente> contato : clientes.entrySet()) {
            Cliente cliente = contato.getValue();
            exibirMensagem("Nome: " + cliente.getNome()
                    + " | Telefone: " + contato.getKey()
                    + " | Email: " + cliente.getEmail());
        }
    }
}