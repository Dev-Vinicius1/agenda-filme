package entities;

import java.time.LocalDateTime;

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

    public LocalDateTime getSessao() {
        return sessao;
    }
}
