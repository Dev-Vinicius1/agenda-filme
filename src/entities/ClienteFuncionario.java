package entities;

import java.util.ArrayList;

public class ClienteFuncionario extends Cliente {
    private String cargo;

    public ClienteFuncionario(
            String nome,
            String telefone,
            String email,
            String cargo
    ) {
        super(nome, telefone, email, 0.3);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void adicionarFilme(ArrayList<Filme> filmes, Filme filme) {
        filmes.add(filme);
    }
}
