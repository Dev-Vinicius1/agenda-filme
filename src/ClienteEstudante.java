public class ClienteEstudante extends Cliente {
    private String matricula;

    public ClienteEstudante(String nome, String telefone, String email,String matricula) {
        super(nome, telefone, email,0.5);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
