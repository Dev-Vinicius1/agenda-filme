import entities.*;
import utils.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        carregaFilmes();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            String exibir = switch (modoDeExibir) {
                case ModoExibir.MENU -> MenuUtils.exibirComprarIngressoECadastro();
                case ModoExibir.CADASTRO -> MenuUtils.exibirCadastro();
            };
            System.out.println(ConsoleColors.WHITE_BOLD + exibir + ConsoleColors.RESET);

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (modoDeExibir) {
                case ModoExibir.MENU:
                    comprarIngressoOuCadastrar(opcao, scanner);
                    break;
                case ModoExibir.CADASTRO:
                    opcaoCadastro(opcao);
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static ModoExibir modoDeExibir = ModoExibir.MENU;

    private static void carregaFilmes() {
        Filme f1 = new Filme("Harold e o Lápis Mágico", 2022, "Animação", "Tudo o que ele desenhou, a realidade vai se tornar. Do diretor Carlos Saldanha.", "Livre", new BigDecimal(25));
        Filme f2 = new Filme("Deadpool & Wolverine", 2024, "Ação", "A Marvel Studios apresenta seu erro mais significativo até agora – Deadpool & Wolverine. Um apático Wade Wilson trabalha duro na vida civil.", "18", new BigDecimal(25));
        Filme f3 = new Filme("Meu Malvado Favorito 4", 2024, "Comedia", "Nesta sequência, o vilão mais amado do planeta retorna e agora Gru, Lucy, Margo, Edith e Agnes dão as boas-vindas a um novo membro da família: Gru Jr.", "Livre", new BigDecimal(25));
        FilmeUtils.addFilmes(List.of(f1, f2, f3));
    }

    private static void opcaoCadastro(int opcao) {
        switch (opcao) {
            case 1 -> ClienteUtils.adicionarCliente();
            case 2 -> ClienteUtils.detalharCliente();
            case 3 -> ClienteUtils.editarContato();
            case 4 -> ClienteUtils.removerCliente();
            case 5 -> ClienteUtils.listarClientes();
            case 6 -> {
                modoDeExibir = ModoExibir.MENU;
                System.out.println("Voltando...");
            }
            case 0 -> System.out.println(ConsoleColors.GREEN_BOLD +"Saindo..." + ConsoleColors.RESET);
            default -> System.out.println(ConsoleColors.RED_BOLD +"Opção inválida!" + ConsoleColors.RESET);
        }
    }

    private static void comprarIngressoOuCadastrar(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1 -> {if (MenuUtils.clienteAtual == null) ClienteUtils.adicionarCliente();}
            case 2 -> {if (MenuUtils.clienteAtual == null) logarCliente(scanner);}
            case 3 -> {if (MenuUtils.clienteAtual !=null) comprarIngresso(scanner);}
            case 4 -> {if (MenuUtils.clienteAtual !=null) exibirHistorico();}
            case 5 -> {if (MenuUtils.clienteAtual !=null) MenuUtils.clienteAtual = null;}
            case 6 -> {if (MenuUtils.clienteAtual instanceof ClienteFuncionario) modoDeExibir = ModoExibir.CADASTRO;}
            case 0 -> System.out.println(ConsoleColors.GREEN_BOLD +"Saindo..." + ConsoleColors.RESET);
            default -> System.out.println(ConsoleColors.RED_BOLD + "Opção inválida!" + ConsoleColors.RESET);
        }
    }

    private static void logarCliente(Scanner scanner) {
        String numeroDeTelefone;
        Cliente cliente;
        String resposta;

        System.out.println(ConsoleColors.BLUE_BOLD +"Digite seu número de telefone: " + ConsoleColors.RESET);
        numeroDeTelefone = scanner.nextLine();

        cliente = ClienteUtils.getClientesMap().get(numeroDeTelefone);
        if (cliente != null) {
            MenuUtils.clienteAtual = cliente;

            System.out.println(ConsoleColors.GREEN_BOLD +"Olá, " +cliente.getNome()+" - Seja bem vindo" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.YELLOW_BOLD +"Cliente não encontrado. Deseja cadastrar um novo? (s/n)" + ConsoleColors.RESET);
            resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                modoDeExibir = ModoExibir.CADASTRO;
            }
        }

    }

    private static void comprarIngresso(Scanner scanner) {
        int codigoFilmeEscolhido;
        Filme filmeSelecionado;
        Ingresso ingresso;
        Sala sala;

        if (MenuUtils.clienteAtual == null) {
            System.out.println(ConsoleColors.RED_BOLD + "É necessário estar logado para comprar um ingresso!" + ConsoleColors.RESET);
            return;
        }

        FilmeUtils.listaFilmes();
        System.out.println(ConsoleColors.BLUE_BOLD + "Escolha o código do filme que deseja comprar o ingresso: " + ConsoleColors.RESET);
        try {
            codigoFilmeEscolhido = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColors.RED_BOLD + "Código inválido." + ConsoleColors.RESET);
            return;
        }

        filmeSelecionado = FilmeUtils.getFilme(codigoFilmeEscolhido);

        if (filmeSelecionado == null) {
            System.out.println(ConsoleColors.RED_BOLD + "Filme não encontrado." + ConsoleColors.RESET);
            return;
        }

        sala = new Sala(1, 30, filmeSelecionado, LocalDateTime.now());
        ingresso = new Ingresso(sala, new BigDecimal(20));
        MenuUtils.clienteAtual.adicionarIngresso(ingresso);

        System.out.println(ConsoleColors.GREEN_BOLD +"Ingresso comprado!" + ConsoleColors.RESET);
    }

    private static void exibirHistorico() {
        String extrato;

        if (MenuUtils.clienteAtual == null) {
            System.out.println(ConsoleColors.RED_BOLD + "É necessário estar logado para ver o histórico!" + ConsoleColors.RESET);
            return;
        }

        extrato = MenuUtils.clienteAtual.getExtratoDosIngressos();

        if (extrato.isEmpty()) {
            System.out.println(ConsoleColors.RED_BOLD + "Não foram comprados ingressos." + ConsoleColors.RESET);
        } else {
            System.out.println("Histórico de ingressos: ");
            System.out.println(extrato);
        }
    }
}