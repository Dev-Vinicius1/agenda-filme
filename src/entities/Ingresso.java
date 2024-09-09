package entities;

import java.math.BigDecimal;

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
    public String toString() 
    {
        return "Ingresso\n"
                + "Título: " + sala.getFilme()
                + "Sessão: " + sala.getSessao()
                + "Sala: " + sala.getNumero()
                + " Valor Ingresso: R$" + getValorIngresso();
    }
}
