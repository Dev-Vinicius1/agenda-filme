package entities;

import utils.FilmeUtils;

public class Filme {

    private  int codigo;
    private String titulo;
    private int anoDeLancamento;
    private String categoria;
    private String sinopse;
    private String classificacaoEtaria;


    public Filme(
            int codigo,
            String titulo,
            int anoDeLancamento,
            String categoria,
            String sinopse,
            String classificacaoEtaria)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.categoria = categoria;
        this.sinopse = sinopse;
        this.classificacaoEtaria = classificacaoEtaria;

        FilmeUtils.codigoCounter++;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "entities.Filme{" +
                "titulo='" + titulo + '\'' +
                ", ano de lancamento=" + anoDeLancamento +
                ", categoria='" + categoria + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", classificacao etaria=" + classificacaoEtaria +
             '}';
    }
}