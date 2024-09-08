package utils;

import entities.Filme;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmeUtils {

    private static final Map<Integer, Filme> filmes = new HashMap<>();
    public static int codigoCounter = 1;

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
