package entities;

import utils.FilmeUtils;

import static utils.FilmeUtils.codigocounter;

public class Filme {

    private  int codigo;
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
        this.codigo = codigocounter;
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.categoria = categoria;
        this.sinopse = sinopse;
        this.classificacaoEtaria = classificacaoEtaria;

         codigocounter++;
    }


    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return  "| COD = " + codigo + "\n" +
                "| Titulo = " + titulo + "\n" +
                "| Lançamento = " + anoDeLancamento + "\n" +
                "| Categoria = " + categoria + "\n" +
                "| Sinopse = " + sinopse + "\n" +
                "| Classificação = " + classificacaoEtaria + "\n";

    }

    //    @Override
//    public String toString() {
//        return "entities.Filme{" +
//                "titulo='" + titulo + '\'' +
//                ", ano de lancamento=" + anoDeLancamento +
//                ", categoria='" + categoria + '\'' +
//                ", sinopse='" + sinopse + '\'' +
//                ", classificacao etaria=" + classificacaoEtaria +
//                '}';
//    }

}
