package entities;

public class ClienteVip extends Cliente {
    public ClienteVip(String nome, String telefone, String email) {
        super(nome, telefone, email, 0.8);
    }

    @Override
    public void adicionarIngresso(Ingresso ingresso) {
        super.adicionarIngresso(ingresso);
    }
}
