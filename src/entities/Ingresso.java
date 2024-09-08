package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;



public class Ingresso extends Filme {
    private String cadeira;
    private int sala;
    private LocalDateTime sessao;
    private BigDecimal preco;


    public Ingresso(
            String titulo,
            int anoDeLancamento,
            String categoria,
            String sinopse,
            String classificacaoEtaria,
            String cadeira,
            int sala,
            BigDecimal preco,
            LocalDateTime sessao
    ) {
        super(titulo, anoDeLancamento, categoria, sinopse, classificacaoEtaria);
        this.cadeira=cadeira;
        this.sala=sala;
        this.sessao=sessao;
    }

    @Override
    public String toString() {
        return "entities.Ingresso{\n"
                +super.toString()
                +"\nsala: "+sala
                +" Sessao: "+sessao.toString()
                +"\n}";
    }
}
