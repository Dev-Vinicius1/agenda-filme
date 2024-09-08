import entities.Cliente;
import entities.ClienteDefault;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, String[]> contatos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        Map<String,Runnable> exibir = new HashMap<String,Runnable>();
        exibir.put("menu", Main::exibirComprarIngressoECadastro);
        exibir.put("cadastro", Main::exibirCadastro);

        do {
            //TODO add try catch because might show null value and not run
            exibir.get(modoDeExibir).run();

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (modoDeExibir){
                case "menu":
                    opcaoComprarIngressoECadastro(opcao, scanner);
                    break;
                case "cadastro":
                    opcaoCadastro(opcao, scanner,  contatos);
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static String modoDeExibir="menu";
    private static Cliente clienteAtual = null;
    private static List<Cliente> clientes = new ArrayList<>();

    private static void exibirCadastro() {
        //TODO mostrar certas coisas sw cliente for default ou funcionario
        System.out.println("\n--- Cadastro ---");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Detalhar contato");
        System.out.println("3. Editar Contato");
        System.out.println("4. Remover Contato");
        System.out.println("5. Listar contatos");
        System.out.println("6. Voltar");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void opcaoCadastro(int opcao, Scanner scanner, Map<String, String[]> contatos){
        switch (opcao) {
            case 1:
                //TODO
                adicionarContato(scanner, contatos);
                break;
            case 2:
                //TODO
                detalharContato(scanner, contatos);
                break;
            case 3:
                //TODO
                editarContato(scanner, contatos);
                break;
            case 4:
                //TODO
                removerContato(scanner, contatos);
                break;
            case 5:
                //TODO
                listarContatos(contatos);
                break;
            case 6:
                modoDeExibir="menu";
                System.out.println("Voltando...");
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void exibirComprarIngressoECadastro(){
        //TODO
        System.out.println("\n--- Auto Atendimento de Cinema ---");
        System.out.println("1. Cadastrar Seu Contato");
        System.out.println("2. Logar com seu Contato");
        if(clienteAtual!=null){
            System.out.println("3. Comprar ingresso");
            System.out.println("4. Ver historico de ingressos");
            System.out.println("5. Deslogar");
        }
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void opcaoComprarIngressoECadastro(int opcao, Scanner scanner){
        //TODO
        switch (opcao) {
            case 1:
                modoDeExibir="cadastro";
                break;
            case 2:
                logarCliente(scanner);
                break;
            case 3:
                comprarIngresso(scanner);
                break;
            case 4:
                exibirHistorico();
                break;
            case 5:
                //TODO
                clienteAtual=null;
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void logarCliente(Scanner scanner) {
        //TODO
        clienteAtual = new ClienteDefault("nometest","11963079537","email@gmail.com");
    }

    private static void comprarIngresso(Scanner scanner) {
        //TODO
    }

    private static void exibirHistorico() {
        //TODO
    }

    private static void adicionarContato(Scanner scanner, Map<String, String[]> contatos) {
        try {
            String nome;
            String numeroDeTelefone;
            String email;

            System.out.print("Digite o nome do contato: ");
            nome = scanner.nextLine();
            System.out.print("Digite o telefone do contato: ");
            numeroDeTelefone = scanner.nextLine();
            System.out.print("Digite o email do contato: ");
            email = scanner.nextLine();

            if (nome.isEmpty() || numeroDeTelefone.isEmpty() || email.isEmpty()) {
                System.out.println("---------------------------");
                throw new Exception("Todos os campos (nome, telefone e e-mail) devem ser preenchidos.");
            }

            if (contatos.containsKey(numeroDeTelefone)) {
                System.out.println("---------------------------");
                throw new Exception("Numero digitado já está sendo usado.");
            }

            contatos.put(numeroDeTelefone, new String[]{nome, email});
            System.out.println("---------------------------");
            System.out.println("Contato Adicionado com sucesso");
            System.out.println("---------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void detalharContato(Scanner scanner, Map<String, String[]> contatos) {
        try {
            System.out.print("Digite o número do contato que deseja ver os detalhes: ");
            String numeroDeTelefone = scanner.nextLine();
            String[] contatoValues = contatos.get(numeroDeTelefone);

            if (contatoValues == null) {
                System.out.println("---------------------------");
                throw new Exception("Contato não encontrado");
            }

            System.out.println("---------------------------");
            System.out.println("Nome: " + contatoValues[0]
                    + " | Telefone: " + numeroDeTelefone
                    + " | Email: " + contatoValues[1]);
            System.out.println("---------------------------");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarContatos(Map<String, String[]> contatos) {
        if (contatos.isEmpty()) {
            System.out.println("---------------------------");
            System.out.println("Agenda vazia");
            System.out.println("---------------------------");
            return;
        }
        for (Map.Entry<String, String[]> contato : contatos.entrySet()) {
            String[] contatoValues = contato.getValue();
            System.out.println("---------------------------");
            System.out.println(
                    "Nome: " + contatoValues[0] + " | Telefone: " + contato.getKey() + " | Email: " + contatoValues[1]);
            System.out.println("---------------------------");

        }
    }

    private static void editarContato(Scanner scanner, Map<String, String[]> contatos) {
        try {
            System.out.print("Digite o telefone do contato que deseja editar: ");
            String numeroDeTelefone = scanner.nextLine();

            String[] contatoValues = contatos.get(numeroDeTelefone);
            if (contatoValues == null) {
                System.out.println("---------------------------");
                throw new Exception("Contato: " + numeroDeTelefone + " não encontrado");
            }

            System.out.print("Digite o novo nome (ou pressione Enter para manter o atual): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                contatoValues[0] = novoNome;
            }

            System.out.print("Digite o novo e-mail (ou pressione Enter para manter o atual): ");
            String novoEmail = scanner.nextLine();
            if (!novoEmail.isEmpty()) {
                contatoValues[1] = novoEmail;
            }

            System.out.print("Digite o novo número de telefone (ou pressione Enter para manter o atual): ");
            String novoNumeroDeTelefone = scanner.nextLine();

            if (!novoNumeroDeTelefone.isEmpty() && !novoNumeroDeTelefone.equals(numeroDeTelefone)) {
                if (contatos.containsKey(novoNumeroDeTelefone)) {
                    System.out.println("---------------------------");
                    throw new Exception("Número de telefone já cadastrado. Atualização não realizada.");
                }

                contatos.remove(numeroDeTelefone);
                contatos.put(novoNumeroDeTelefone, contatoValues);
                System.out.println("---------------------------");
                System.out.println("Número de telefone atualizado com sucesso.");
                System.out.println("---------------------------");
            } else {
                contatos.put(numeroDeTelefone, contatoValues);
                System.out.println("---------------------------");
                System.out.println("Contato atualizado com sucesso.");
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerContato(Scanner scanner, Map<String, String[]> contatos) {
        try {
            System.out.println("Digite o numero de contato para excluir: ");
            String numeroDeTelefone = scanner.nextLine();

            if (!contatos.containsKey(numeroDeTelefone)) {
                System.out.println("---------------------------");
                throw new Exception("Contato:" + numeroDeTelefone + " Não foi encontrado. ");
            }
            contatos.remove(numeroDeTelefone);
            System.out.println("---------------------------");
            System.out.println("Contato removido com sucesso!");
            System.out.println("---------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}