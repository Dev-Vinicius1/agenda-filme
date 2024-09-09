package utils;

import entities.Cliente;
import entities.ClienteFuncionario;

public class MenuUtils {

    public static Cliente clienteAtual = null;

    public static String exibirCadastro() {

        return """
                --- Cadastro ---\s
                1. Adicionar usuário\s
                2. Detalhar usuário\s
                3. Editar usuário\s
                4. Remover usuário\s
                5. Listar usuários\s
                6. Voltar
                0. Sair\s
                Escolha uma opção:\s""";
    }

    public static String exibirComprarIngressoECadastro() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Auto Atendimento de Cinema ---\n");

        if (clienteAtual == null) {
            sb.append("1. Registrar\n");
            sb.append("2. Fazer login\n");
        }
        if (clienteAtual != null) {
            sb.append("3. Comprar ingresso\n");
            sb.append("4. Ver historico de ingressos\n");
            sb.append("5. Deslogar\n");
        }
        if (clienteAtual instanceof ClienteFuncionario) {
            sb.append("6. Manutenção de Usuarios\n");
        }
        sb.append("0. Sair\n");
        sb.append("Escolha uma opção: ");
        return sb.toString();
    }
}
