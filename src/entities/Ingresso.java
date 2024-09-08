package entities;

import java.math.BigDecimal;

public class Ingresso {

    private Sala sala;
    private BigDecimal valor;

    public Ingresso(Sala sala, BigDecimal valor)
    {
        this.sala = sala;
        this.valor = valor;
    }

    @Override
    public String toString() 
    {
        return "Ingresso\n"
                + "Título: " + sala.getFilme()
                + "Sessão: " + sala.getSessao()
                + "Sala: " + sala.getNumero()
                + "Valor: R$" + valor.toString();
    }
}
