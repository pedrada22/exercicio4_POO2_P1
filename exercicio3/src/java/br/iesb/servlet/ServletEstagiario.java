package br.iesb.servlet;

import br.iesb.dao.GenericaDAO;
import br.iesb.modelo.Estagiario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletEstagiario",
        urlPatterns = "/verEstagiario")
public class ServletEstagiario extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //capturando informações vinda das páginas
        String operacao = request.getParameter("operacao");
        String acao = request.getParameter("acao");
        String idEstagiario = request.getParameter("idEstagiario");
        String txNome = request.getParameter("txNome");
        String txCurso = request.getParameter("txCurso");
        String nfValorBolsa = request.getParameter("nfValorBolsa");
        String nfValorTicketRefeicao = request.getParameter("nfValorTicketRefeicao");
        String niCargaHoraria = request.getParameter("niCargaHoraria");
        String niAnosExperiencia = request.getParameter("niAnosExperiencia");
        String niDuracaoEstagio = request.getParameter("niDuracaoEstagio");
       
        String pagina = "";
        if (operacao == null) {
            operacao = "iniciar";
        }
        operacao = operacao.toLowerCase();

        if (acao == null) {
            acao = "";
        }
        acao = acao.toLowerCase();

        Estagiario estagio = new Estagiario();
        
        GenericaDAO dao = new GenericaDAO(estagio);

        //validando...
        if (idEstagiario != null && !"".equals(idEstagiario)) {
            estagio.setIdEstagiario(Integer.parseInt(idEstagiario));
        }
        if (txNome != null && !"".equals(txNome)) {
            estagio.setTxNome(txNome);
        }
        if (txCurso != null && !"".equals(txCurso)) {
            estagio.setTxCurso(txCurso);
        }
        if (nfValorBolsa != null && !"".equals(nfValorBolsa)) {
            estagio.setNfValorBolsa(Double.parseDouble(nfValorBolsa));
        }
        if (nfValorTicketRefeicao != null && !"".equals(nfValorTicketRefeicao)) {
            estagio.setNfValorTicketRefeicao(Double.parseDouble(nfValorTicketRefeicao));
        }
        if (niCargaHoraria != null && !"".equals(niCargaHoraria)) {
            estagio.setNiCargaHoraria(Integer.parseInt(niCargaHoraria));
        }
        if (niAnosExperiencia != null && !"".equals(niAnosExperiencia)) {
            estagio.setNiAnosExperiencia(Integer.parseInt(niAnosExperiencia));
        }
         if (niDuracaoEstagio != null && !"".equals(niDuracaoEstagio)) {
            estagio.setNiDuracaoEstagio(Integer.parseInt(niDuracaoEstagio));
        }

        //tratando a operação
        if ("iniciar".equals(operacao)) {
            pagina = "/index.jsp";
        } else {  //operacao = novo ou alterar ou excluir
            pagina = "/formulario.jsp";
        }

        //tratar a ação
        if ("incluir".equals(acao) || "salvar".equals(acao)) {
            dao.salvar(estagio);
            pagina = "/formulario.jsp";
            if ("incluir".equals(acao)) {
                pagina = "/index.jsp";
            }
            //limpar campos
        } else if ("excluir".equals(acao)) {
            dao.excluir(estagio);
            pagina = "/index.jsp";
        } else if ("voltar".equals(acao)) {
            pagina = "/index.jsp";
        }

        if (!"".equals(idEstagiario) && idEstagiario != null && !"excluir".equals(acao)) {
            estagio = (Estagiario) dao.getModelo("br.iesb.modelo.Estagiario", Integer.parseInt(idEstagiario));

            txNome = estagio.getTxNome();
            txCurso = "" + estagio.getTxCurso();
            nfValorBolsa = "" + estagio.getNfValorBolsa();
            nfValorTicketRefeicao = "" + estagio.getNfValorTicketRefeicao();
            niCargaHoraria = "" + estagio.getNiCargaHoraria();
            niAnosExperiencia = "" + estagio.getNiAnosExperiencia();
            niDuracaoEstagio = "" + estagio.getNiDuracaoEstagio();
            

        }

        //devolvendo pelo request
        request.setAttribute("lista", dao.lista("Estagiario"));
        request.setAttribute("operacao", operacao);
        request.setAttribute("acao", acao);
        request.setAttribute("idEstagiario", idEstagiario);
        request.setAttribute("txNome", txNome);
        request.setAttribute("txCurso", txCurso);
        request.setAttribute("nfValorBolsa", nfValorBolsa);
        request.setAttribute("nfValorTicketRefeicao", nfValorTicketRefeicao);
        request.setAttribute("niCargaHoraria", niCargaHoraria);
        request.setAttribute("niAnosExperiencia", niAnosExperiencia);
        request.setAttribute("niDuracaoEstagio", niDuracaoEstagio);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }
}
