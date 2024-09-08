package utils;

public enum ModoExibir {
    MENU("menu"),
    CADASTRO("cadastro");

    private final String descricao;

    ModoExibir(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
