import entities.*;
import utils.ClienteUtils;
import utils.FilmeUtils;
import utils.MenuUtils;

import java.time.LocalDateTime;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        carregaFilmes();

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        Map<String, String> exibir = new HashMap<>();
        exibir.put("menu", MenuUtils.exibirComprarIngressoECadastro());
        exibir.put("cadastro", MenuUtils.exibirCadastro());


        do {
            //TODO add try catch because might show null value and not run
            System.out.println(exibir.get(modoDeExibir));

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
        Filme f1 = new Filme("Harold e o Lápis Mágico", 2022, "Animação", "Tudo o que ele desenhou, a realidade vai se tornar. Do diretor Carlos Saldanha.", "Livre");
        Filme f2 = new Filme("Deadpool & Wolverine", 2024, "Ação", "A Marvel Studios apresenta seu erro mais significativo até agora – Deadpool & Wolverine. Um apático Wade Wilson trabalha duro na vida civil.", "18");
        Filme f3 = new Filme("Meu Malvado Favorito 4", 2024, "Comedia", "Nesta sequência, o vilão mais amado do planeta retorna e agora Gru, Lucy, Margo, Edith e Agnes dão as boas-vindas a um novo membro da família: Gru Jr.", "Livre");
        FilmeUtils.addFilmes(List.of(f1, f2, f3));
    }

    private static String modoDeExibir = "menu";
    //   private static Cliente clienteAtual = null;
    private static List<Cliente> clientes = new ArrayList<>();


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


    private static void comprarIngressoOuCadastrar(int opcao, Scanner scanner) {
        //TODO
        switch (opcao) {
            case 1:
                modoDeExibir = "menu";
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
                MenuUtils.clienteAtual = null;
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void logarCliente(Scanner scanner) {
        String numeroDeTelefone;
        Cliente cliente;
        String resposta;
      
        System.out.println("Digite seu número de telefone: ");
        numeroDeTelefone = scanner.nextLine();

        cliente = ClienteUtils.getClientesMap().get(numeroDeTelefone);
        if (cliente != null) 
        {
            MenuUtils.clienteAtual = cliente;
            System.out.println("Login realizado com sucesso!");
        } 
        else 
        {
            System.out.println("Cliente não encontrado. Deseja cadastrar um novo? (s/n)");
            resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")) 
            {
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