package utils;

import entities.Filme;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmeUtils {

    private static final Map<Integer, Filme> filmes = new HashMap<>();
    public static int codigoCounter = 1;

    Filme filme = new Filme(1, "Harry Potter", 2012, "sla", "é bom!", "10");
    Filme filme1 = new Filme(2, "Top Gun", 2022, "sla2", "é bom2!", "16");

    public static void addFilme(Filme filme) 
    {
        filmes.put(filme.getCodigo(), filme);
    }

    public static void addFilmes(List<Filme> filmes)
    {
        for(Filme filme : filmes)
        {
            addFilme(filme);
        }
    }
    public static Filme getFilme(int codigo)
    {
        return filmes.get(codigo);
    }


    public static void listaFilmes() 
    {
        for (Map.Entry<Integer, Filme> filmes : filmes.entrySet()) 
        {
           Filme filmeValues = filmes.getValue();
            System.out.println(filmeValues);
            System.out.println();
        }
    }
}
