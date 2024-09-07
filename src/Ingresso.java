import java.time.LocalDateTime;

public class Ingresso extends  Filme{
    private String cadeira;
    private int sala;
    private LocalDateTime sessao;

    public Ingresso(
            String titulo,
            int anoDeLancamento,
            String categoria,
            String sinopse,
            int classificacaoEtaria,
            String cadeira,
            int sala,
            LocalDateTime sessao
    ) {
        super(titulo, anoDeLancamento, categoria, sinopse, classificacaoEtaria);
        this.cadeira=cadeira;
        this.sala=sala;
        this.sessao=sessao;
    }

    @Override
    public String toString() {
        return "Ingresso{\n"
                +super.toString()
                +"\nsala: "+sala
                +" Sessao: "+sessao.toString()
                +"\n}";
    }
}
