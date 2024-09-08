import entities.Cliente;
import entities.ClienteDefault;
import entities.Filme;
import utils.ClienteUtils;
import utils.FilmeUtils;
import utils.MenuUtils;
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
        //TODO
        MenuUtils.clienteAtual = new ClienteDefault("nometest", "11963079537", "email@gmail.com");
    }

    private static void comprarIngresso(Scanner scanner) {
        //TODO
    }

    private static void exibirHistorico() {
        //TODO
    }


}