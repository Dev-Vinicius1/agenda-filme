package entities;

import utils.FilmeUtils;
import static utils.FilmeUtils.codigoCounter;



public class Filme {

    private int codigo;
    private String titulo;
    private int anoDeLancamento;
    private String categoria;
    private String sinopse;
    private String classificacaoEtaria;


    public Filme(
            String titulo,
            int anoDeLancamento,
            String categoria,
            String sinopse,
            String classificacaoEtaria) 
    {
        this.codigo = codigoCounter;
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.categoria = categoria;
        this.sinopse = sinopse;
        this.classificacaoEtaria = classificacaoEtaria;
        codigoCounter++;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "| COD = " + codigo + "\n" +
                "| Titulo = " + titulo + "\n" +
                "| Lançamento = " + anoDeLancamento + "\n" +
                "| Categoria = " + categoria + "\n" +
                "| Sinopse = " + sinopse + "\n" +
                "| Classificação = " + classificacaoEtaria + "\n";
    }

    public String getTitulo() {
        return titulo;
    }
}



