import entities.*;
import utils.ClienteUtils;
import utils.FilmeUtils;

import java.time.LocalDateTime;
import java.util.*;

import static utils.FilmeUtils.codigoCounter;

public class Main {
    public static void main(String[] args) {

        carregaFilmes();

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        Map<String, Runnable> exibir = new HashMap<String, Runnable>();
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

            switch (modoDeExibir) {
                case "menu":
                    comprarIngressoOuCadastrar(opcao, scanner);
                    break;
                case "cadastro":
                    opcaoCadastro(opcao);
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void carregaFilmes() {
        Filme f1 = new Filme(codigoCounter, "Harold e o Lápis Mágico", 2022, "Animação", "Tudo o que ele desenhou, a realidade vai se tornar. Do diretor Carlos Saldanha.", "Livre");
        Filme f2 = new Filme(codigoCounter, "Deadpool & Wolverine", 2024, "Ação", "A Marvel Studios apresenta seu erro mais significativo até agora – Deadpool & Wolverine. Um apático Wade Wilson trabalha duro na vida civil.", "18");
        Filme f3 = new Filme(codigoCounter, "Meu Malvado Favorito 4", 2024, "Comedia", "Nesta sequência, o vilão mais amado do planeta retorna e agora Gru, Lucy, Margo, Edith e Agnes dão as boas-vindas a um novo membro da família: Gru Jr.", "Livre");
        FilmeUtils.addFilmes(List.of(f1, f2, f3));
    }

    private static String modoDeExibir = "menu";
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

    private static void opcaoCadastro(int opcao) {
        switch (opcao) {
            case 1:
                ClienteUtils.adicionarCliente();
                break;
            case 2:
                ClienteUtils.detalharCliente();
                break;
            case 3:
                ClienteUtils.editarContato();
                break;
            case 4:
                ClienteUtils.removerCliente();
                break;
            case 5:
                ClienteUtils.listarClientes();
                break;
            case 6:
                modoDeExibir = "menu";
                System.out.println("Voltando...");
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void exibirComprarIngressoECadastro() {
        //TODO
        System.out.println("\n--- Auto Atendimento de Cinema ---");
        System.out.println("1. Registrar");
        System.out.println("2. Fazer login");
        if (clienteAtual != null) {
            System.out.println("3. Comprar ingresso");
            System.out.println("4. Ver historico de ingressos");
            System.out.println("5. Deslogar");
        }
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void comprarIngressoOuCadastrar(int opcao, Scanner scanner) {
        //TODO
        switch (opcao) {
            case 1:
                modoDeExibir = "cadastro";
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
                clienteAtual = null;
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void logarCliente(Scanner scanner) {
        System.out.println("Digite seu número de telefone: ");
        String numeroDeTelefone = scanner.nextLine();

        Cliente cliente = ClienteUtils.getClientesMap().get(numeroDeTelefone);
        if (cliente != null) {
            clienteAtual = cliente;
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado. Deseja cadastrar um novo? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                modoDeExibir = "cadastro";
            }
        }
    }

    private static void comprarIngresso(Scanner scanner) {
        if (clienteAtual == null) {
            System.out.println("É necessário estar logado para comprar um ingresso!");
            return;
        }

        FilmeUtils.listaFilmes();
        System.out.println("Escolha o código do filme que deseja comprar o ingresso: ");
        int codigoFilmeEscolhido;
        try {
            codigoFilmeEscolhido = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Código inválido.");
            return;
        }

        Filme filmeSelecionado = FilmeUtils.getFilme(codigoFilmeEscolhido);

        if (filmeSelecionado == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        Sala sala = new Sala(1, 30, filmeSelecionado, LocalDateTime.now());
        Ingresso ingresso = new Ingresso(sala);
        clienteAtual.adicionarIngresso(ingresso);

        System.out.println("Ingresso comprado!");

    }

    private static void exibirHistorico() {
        if(clienteAtual == null){
            System.out.println("É necessário estar logado para ver o histórico!");
            return;
        }

        String extrato = clienteAtual.getExtratoDosIngressos();

        if(extrato.isEmpty()){
            System.out.println("Não foram comprados ingressos.");
        }else{
            System.out.println("Histórico de ingressos: ");
            System.out.println(extrato);
        }
    }


}