
public class Filme {

    private static int quantidadeDeFilmesEIngressos;
    private final int id;
    private String titulo;
    private int anoDeLancamento;
    private String categoria;
    private String sinopse;
    private int classificacaoEtaria;


    public Filme(
            String titulo,
            int anoDeLancamento,
            String categoria,
            String sinopse,
            int classificacaoEtaria
    ) {
        quantidadeDeFilmesEIngressos = quantidadeDeFilmesEIngressos +1;
        this.id = quantidadeDeFilmesEIngressos;
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.categoria = categoria;
        this.sinopse = sinopse;
        this.classificacaoEtaria = classificacaoEtaria;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", ano de lancamento=" + anoDeLancamento +
                ", categoria='" + categoria + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", classificacao etaria=" + classificacaoEtaria +
                '}';
    }
}
