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

            System.out.print(ConsoleColors.BLUE_BOLD + "Digite seu nome: " + ConsoleColors.RESET);
            nome = sc.nextLine();

                System.out.print(ConsoleColors.BLUE_BOLD + "Digite seu telefone: " + ConsoleColors.RESET);
                String tel = sc.nextLine();
                Integer.parseInt(tel);
                telefone = tel;




            System.out.print(ConsoleColors.BLUE_BOLD + "Digite seu email: " + ConsoleColors.RESET);
            email = sc.nextLine();

            do {
                System.out.println(ConsoleColors.BLUE_BOLD + "Digite o código da sua categoria: " + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN_BOLD + "A - VIP" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN_BOLD + "B - Estudante" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN_BOLD + "C - Funcionário" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN_BOLD + "D - Convencional" + ConsoleColors.RESET);
                categoria = sc.nextLine().trim().toUpperCase();
                if (!categoria.equals("A") && !categoria.equals("B") && !categoria.equals("C") && !categoria.equals("D")) {
                    System.out.println(ConsoleColors.RED_BOLD + "Opção inválida." + ConsoleColors.RESET);
                }
            } while (!categoria.equals("A") && !categoria.equals("B") && !categoria.equals("C") && !categoria.equals("D"));
            System.out.println(ConsoleColors.BLUE_BOLD + "Categoria escolhida: " + categoria + ConsoleColors.RESET);

            if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                System.out.println("---------------------------------------");
                throw new Exception(ConsoleColors.RED_BOLD+ "Todos os campos devem ser preenchidos." + ConsoleColors.RESET);
            }

            if (clientes.containsKey(telefone)) {
                System.out.println("-------------------------------------");
                throw new Exception(ConsoleColors.RED_BOLD+ "Número digitado já está sendo usado." + ConsoleColors.RESET);
            }

            Cliente cliente = null;
            switch (categoria) {
                case "A" -> cliente = new ClienteVip(nome, telefone, email);
                case "B" -> {
                    System.out.print(ConsoleColors.BLUE_BOLD + "Digite sua matricula: " + ConsoleColors.RESET);
                    String matricula = sc.nextLine();
                    cliente = new ClienteEstudante(nome, telefone, email, matricula);
                }
                case "C" -> {
                    System.out.print(ConsoleColors.BLUE_BOLD + "Digite seu cargo: " + ConsoleColors.RESET);
                    String cargo = sc.nextLine();
                    cliente = new ClienteFuncionario(nome, telefone, email, cargo);
                }
                case "D" -> cliente = new ClienteDefault(nome, telefone, email);
            }
            clientes.put(telefone, cliente);
            exibirMensagem(ConsoleColors.GREEN_BOLD +"Contato adicionado com sucesso." + ConsoleColors.RESET);
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
                throw new Exception(ConsoleColors.RED_BOLD + "Contato:" + numeroDeTelefone + " Não foi encontrado. " + ConsoleColors.RESET);
            }
            clientes.remove(numeroDeTelefone);
            exibirMensagem(ConsoleColors.GREEN_BOLD +"Contato removido com sucesso!" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD + e.getMessage()  + ConsoleColors.RESET);
        }
    }

    public static void editarContato() {
        try {
            System.out.print(ConsoleColors.BLUE_BOLD + "Digite o telefone do contato que deseja editar: " + ConsoleColors.RESET);
            String numeroDeTelefone = sc.nextLine();

            Cliente cliente = clientes.get(numeroDeTelefone);
            if (cliente == null) {
                System.out.println("---------------------------");
                throw new Exception(ConsoleColors.RED_BOLD + "Contato: " + numeroDeTelefone + " não encontrado" + ConsoleColors.RESET);
            }

            System.out.print(ConsoleColors.BLUE_BOLD + "Digite o novo nome (ou pressione Enter para manter o atual): " + ConsoleColors.RESET);
            String novoNome = sc.nextLine();
            if (!novoNome.isEmpty()) {
                cliente.setNome(novoNome);
            }

            System.out.print(ConsoleColors.BLUE_BOLD + "Digite o novo e-mail (ou pressione Enter para manter o atual): "+ ConsoleColors.RESET);
            String novoEmail = sc.nextLine();
            if (!novoEmail.isEmpty()) {
                cliente.setEmail(novoEmail);
            }

            System.out.print(ConsoleColors.BLUE_BOLD + "Digite o novo número de telefone (ou pressione Enter para manter o atual): " + ConsoleColors.RESET);
            String novoNumeroDeTelefone = sc.nextLine();

            if (!novoNumeroDeTelefone.isEmpty() && !novoNumeroDeTelefone.equals(numeroDeTelefone)) {
                if (clientes.containsKey(novoNumeroDeTelefone)) {
                    System.out.println("---------------------------");
                    throw new Exception(ConsoleColors.RED_BOLD + "Número de telefone já cadastrado. Atualização não realizada." + ConsoleColors.RESET);
                }

                clientes.remove(numeroDeTelefone);
                clientes.put(novoNumeroDeTelefone, cliente);
                exibirMensagem(ConsoleColors.GREEN_BOLD +"Número de telefone atualizado com sucesso." + ConsoleColors.RESET);
            } else {
                clientes.put(numeroDeTelefone, cliente);
                exibirMensagem(ConsoleColors.GREEN_BOLD + "Contato atualizado com sucesso." + ConsoleColors.RESET);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void detalharCliente() {
        try {
            System.out.print(ConsoleColors.BLUE_BOLD + "Digite o número do contato que deseja ver os detalhes: " + ConsoleColors.RESET);
            String numeroDeTelefone = sc.nextLine();
            Cliente cliente = clientes.get(numeroDeTelefone);

            if (cliente == null) {
                System.out.println("---------------------------");
                throw new Exception(ConsoleColors.RED_BOLD + "Contato não encontrado"+ ConsoleColors.RESET);
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
            exibirMensagem(ConsoleColors.RED_BOLD + "Cadastro de clientes está vazio" + ConsoleColors.RESET);
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