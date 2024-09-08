package entities;

public class Ingresso {

    private Sala sala;

    public Ingresso(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Ingresso\n"
                + "Título: " + sala.getFilme().getTitulo()
                + "Sessão: " + sala.getSessao()
                + "Sala: " + sala.getNumero();
    }
}
