package utils;

import entities.Cliente;

public class MenuUtils {

    private static Cliente clienteAtual = null;

    public static void exibirComprarIngressoECadastro(){
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

    public static void exibirCadastro() {
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


}
