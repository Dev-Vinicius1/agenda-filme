
public class Filme {

    private  int id;
    private String titulo;
    private int anoDeLancamento;
    private String categoria;
    private String sinopse;
    private int classificacaoEtaria;


    public Filme(int id, String titulo, int anoDeLancamento, String categoria, String sinopse, int classificacaoEtaria) {
       this.id = id;
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.categoria = categoria;
        this.sinopse = sinopse;
        this.classificacaoEtaria = classificacaoEtaria;
    }
}
