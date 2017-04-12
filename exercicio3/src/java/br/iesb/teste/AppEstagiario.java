
package br.iesb.teste;

import br.iesb.dao.GenericaDAO;
import br.iesb.modelo.Estagiario;
import java.util.List;


public class AppEstagiario {
    public static void main (String [] args ){
        
        Estagiario estagio = new Estagiario();

        estagio.setTxNome("INGLES");
        estagio.setTxCurso("Português");
        estagio.setNfValorBolsa(500);
        estagio.setNfValorTicketRefeicao(200);
        estagio.setNiCargaHoraria(1200);
        estagio.setNiAnosExperiencia(15);
        estagio.setNiDuracaoEstagio(6);
        
        
                       

        GenericaDAO dao = new GenericaDAO(estagio);
        dao.salvar(estagio);

        List<Estagiario> lista = dao.lista("Estagiario");

        for (Estagiario p : lista) {
            System.out.println(p.getTxNome());
        }
    }
    
}
