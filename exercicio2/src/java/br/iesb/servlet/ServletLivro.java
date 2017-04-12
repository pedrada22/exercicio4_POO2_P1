
package br.iesb.servlet;

import br.iesb.livro.Livro;
import br.iesb.dao.GenericaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletLivro",
        urlPatterns = "/verLivro")
public class ServletLivro extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //capturando informações vinda das páginas
        String operacao = request.getParameter("operacao");
        String acao = request.getParameter("acao");
        String idLivro = request.getParameter("idLivro");
        String txTitulo = request.getParameter("txTitulo");
        String txAutor = request.getParameter("txAutor");
        String txPaginas = request.getParameter("txPaginas");
        String txISBN = request.getParameter("txISBN");

        String pagina = "";
        if (operacao == null) {
            operacao = "iniciar";
        }
        operacao = operacao.toLowerCase();

        if (acao == null) {
            acao = "";
        }
        acao = acao.toLowerCase();

        Livro livro = new Livro();
        GenericaDAO dao = new GenericaDAO(livro);

        //validando...
        if (idLivro != null && !"".equals(idLivro)) {
            livro.setIdLivro(Integer.parseInt(idLivro));
        }
        if (txTitulo != null && !"".equals(txTitulo)) {
            livro.setTxTitulo(txTitulo);
        }
        if (txAutor != null && !"".equals(txAutor)) {
            livro.setTxAutor(txAutor);
        }
        if (txPaginas != null && !"".equals(txPaginas)) {
            livro.setTxPaginas(txPaginas);
        }
        if (txISBN != null && !"".equals(txISBN)) {
            livro.setTxISBN(txISBN);
        }

        //tratando a operação
        if ("iniciar".equals(operacao)) {
            pagina = "/index.jsp";
        } else {  //operacao = novo ou alterar ou excluir
            pagina = "/formulario.jsp";
        }

        //tratar a ação
        if ("incluir".equals(acao) || "salvar".equals(acao)) {
            dao.salvar(livro);
            pagina = "/formulario.jsp";
            if("incluir".equals(acao)){
                pagina = "/index.jsp";
            }
            //limpar campos
        } else if ("excluir".equals(acao)) {
            dao.excluir(livro);
            pagina = "/index.jsp";
        } else if ("voltar".equals(acao)) {
            pagina = "/index.jsp";
        }

        if (!"".equals(idLivro) && idLivro != null && !"excluir".equals(acao)) {
            livro = (Livro) dao.getModelo("br.iesb.livro.Livro", Integer.parseInt(idLivro));

            txTitulo = livro.getTxTitulo();
            txAutor = "" + livro.getTxAutor();
            txPaginas = "" + livro.getTxPaginas();
            txISBN = "" + livro.getTxISBN();

        }

        //devolvendo pelo request
        request.setAttribute("lista", dao.lista("Livro"));
        request.setAttribute("operacao", operacao);
        request.setAttribute("acao", acao);
        request.setAttribute("idLivro", idLivro);
        request.setAttribute("txTitulo", txTitulo);
        request.setAttribute("txAutor", txAutor);
        request.setAttribute("txPaginas", txPaginas);
        request.setAttribute("txISBN", txISBN);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }
}
