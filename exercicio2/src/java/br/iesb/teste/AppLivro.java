
package br.iesb.teste;

import br.iesb.dao.GenericaDAO;
import br.iesb.livro.Livro;
import java.util.List;


public class AppLivro {
    public static void main (String [] args ){
        
        Livro livro = new Livro();

        livro.setTxTitulo("Java");
        livro.setTxAutor("Iesb");
        livro.setTxPaginas("200");
        livro.setTxISBN("978");

        GenericaDAO dao = new GenericaDAO(livro);
        dao.salvar(livro);

        List<Livro> lista = dao.lista("Livro");

        for (Livro p : lista) {
            System.out.println(p.getTxTitulo());
        }
    }
}

