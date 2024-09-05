import java.math.BigDecimal;

public class Cliente {
    protected String nome;
    protected String telefone;
    protected String email;
    protected String historicoDeIngrssos;

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.historicoDeIngrssos = null;
    }

    public String getNome() {
        return nome;
    }

    public String getHistoricoDeIngrssos() {
        return historicoDeIngrssos;
    }

    public String getTelefone() {
        return telefone;
    }
}
