package utils;

import entities.Cliente;

public class MenuUtils {

    public static Cliente clienteAtual = null;

    public static String exibirCadastro() {
        //TODO mostrar certas coisas sw cliente for default ou funcionario
        return "\n--- Cadastro --- \n" +
                "1. Adicionar usuário \n" +
                "2. Detalhar usuário \n" +
                "3. Editar usuário \n" +
                "4. Remover usuário \n" +
                "5. Listar usuários \n" +
                "6. Voltar\n" +
                "0. Sair \n" +
                "Escolha uma opção: ";
    }

    public static String exibirComprarIngressoECadastro() {
        //TODO
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Auto Atendimento de Cinema ---\n");
        sb.append("1. Registrar\n");
        sb.append("2. Fazer login\n");
        if (clienteAtual != null) {
            sb.append("3. Comprar ingresso\n");
            sb.append("4. Ver historico de ingressos\n");
            sb.append("5. Deslogar\n");
        }
        sb.append("0. Sair\n");
        sb.append("Escolha uma opção: ");
        return sb.toString();
    }
}
