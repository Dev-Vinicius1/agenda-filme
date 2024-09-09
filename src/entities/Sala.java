package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sala {

    private int numero;
    private int qtdPoltronas;
    private Filme filme;
    private LocalDateTime sessao;

    public Sala(int numero, int qtdPoltronas, Filme filme, LocalDateTime sessao) {
        this.numero = numero;
        this.qtdPoltronas = qtdPoltronas;
        this.filme = filme;
        this.sessao = sessao;
    }

    public int getNumero() {
        return numero;
    }

    public Filme getFilme() {
        return filme;
    }

    public String getSessao() {
        DateTimeFormatter formatacaoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss ");
        return sessao.format(formatacaoHora);
    }
}
