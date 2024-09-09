package entities;

import utils.ConsoleColors;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ingresso {

    private Sala sala;
    private BigDecimal valorIngresso;

    public Ingresso(Sala sala, BigDecimal valorIngresso)
    {
        this.sala = sala;
        this.valorIngresso = valorIngresso;
    }

    public BigDecimal getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(BigDecimal valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    @Override
    public String toString() {
        return ConsoleColors.BLUE_BOLD + "Ingresso\n" + ConsoleColors.RESET
                + ConsoleColors.YELLOW_BOLD + "Título: " + ConsoleColors.RESET + sala.getFilme().getTitulo() + "\n"
                + ConsoleColors.YELLOW_BOLD + "Sessão: " + ConsoleColors.RESET + sala.getSessao() + "\n"
                + ConsoleColors.YELLOW_BOLD + "Sala: " + ConsoleColors.RESET + sala.getNumero() + "\n"
                + ConsoleColors.YELLOW_BOLD + "Valor Ingresso: R$ " + ConsoleColors.RESET + getValorIngresso().setScale(2, RoundingMode.HALF_UP) + "\n";
    }
}
