package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static utils.FilmeUtils.codigoCounter;

public class Filme {

    private int codigo;
    private String titulo;
    private int anoDeLancamento;
    private String categoria;
    private String sinopse;
    private String classificacaoEtaria;
    private BigDecimal valorIngresso;


    public Filme(String titulo, int anoDeLancamento, String categoria, String sinopse,
                 String classificacaoEtaria, BigDecimal valorIngresso) {
        this.codigo = codigoCounter;
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.categoria = categoria;
        this.sinopse = sinopse;
        this.classificacaoEtaria = classificacaoEtaria;
        this.valorIngresso = valorIngresso;
        codigoCounter++;
    }

    public int getCodigo() {
        return codigo;
    }

    public BigDecimal getValorIngresso() {
        return valorIngresso;
    }

    @Override
    public String toString() {
        return "| COD = " + codigo + "\n" +
               "| Titulo = " + titulo + "\n" +
               "| Lançamento = " + anoDeLancamento + "\n" +
               "| Categoria = " + categoria + "\n" +
               "| Sinopse = " + sinopse + "\n" +
               "| Classificação = " + classificacaoEtaria + "\n" +
               "| Valor Ingresso = R$" + valorIngresso.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getTitulo() {
        return titulo;
    }
}



