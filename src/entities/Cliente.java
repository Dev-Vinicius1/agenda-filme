package entities;

import java.util.ArrayList;

public class Cliente {
    protected String nome;
    protected String telefone;
    protected String email;
    protected ArrayList<Ingresso> ingressos;
    private final double disconto;

    private Cliente(String nome, String telefone, String email, ArrayList<Ingresso>ingressos, double disconto) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.ingressos = ingressos ;
        this.disconto=disconto;
    }

    public Cliente(String nome, String telefone, String email) {
        this(nome,telefone,email,new ArrayList<>(),1);
    }

    public Cliente(String nome, String telefone, String email,double disconto) {
        this(nome,telefone,email,new ArrayList<>(),disconto);
    }
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void adicionarIngresso(Ingresso ingresso)
    {
        ingressos.add(ingresso);
    }

    public String getExtratoDosIngressos() {
        String extrato="";
        for(Ingresso ingresso: ingressos){
            extrato=extrato.concat(ingresso.toString()+"\n");
        }
        return extrato;
    }

    public double getDisconto() {
        return disconto;
    }
}
