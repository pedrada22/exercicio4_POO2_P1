package br.iesb.servlet;

import br.iesb.dao.GenericaDAO;
import br.iesb.modelo.Livro;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //capturando informações vinda das páginas
        String operacao = request.getParameter("operacao");
        String acao = request.getParameter("acao");
        String idLivro = request.getParameter("idLivro");
        String txTitulo = request.getParameter("txTitulo");
        String txAutor = request.getParameter("txAutor");
        String intPaginas = request.getParameter("intPaginas");
        String errosJava = "";
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
        
        //validando...
        if (idLivro != null && !"".equals(idLivro)) {
            try
            {
              livro.setIdLivro(Integer.parseInt(idLivro));
            }
            catch(Exception e)
            {
                System.out.println("Erro ao colocar Id como inteiro");
                errosJava = "Erro ao colocar Id como inteiro";
            }
            
            
        }
        if (txTitulo != null && !"".equals(txTitulo)) {
            livro.setTxTitulo(txTitulo);
        }
        if (txAutor != null && !"".equals(txAutor)) {
            livro.setTxAutor(txAutor);
        }
        if (txISBN != null && !"".equals(txISBN)) {
            livro.setTxISBN(txISBN);
        }
        if (intPaginas != null && !"".equals(intPaginas)) {
            try
            {
              livro.setIntPaginas(Integer.parseInt(intPaginas));
            }
            catch(Exception e)
            {
                System.out.println("Erro ao colocar Paginas como inteiro");
                
                errosJava = "Erro ao colocar paginas como inteiro";
            }            
            
        }
        
        //tratando a operação
        if ("iniciar".equals(operacao)) {
            pagina = "/index.jsp";
        } else {  //operacao = novo ou alterar ou excluir
            pagina = "/formulario.jsp";
        }

        GenericaDAO dao = new GenericaDAO(livro);
        
        //tratar a ação
        if ("incluir".equals(acao) || "salvar".equals(acao)) {
            dao.salvar(livro);
            pagina = "/formulario.jsp";
            if ("incluir".equals(acao)) {
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
            livro = (Livro) dao.getModelo("br.iesb.modelo.Livro", Integer.parseInt(idLivro));

            txTitulo = livro.getTxTitulo();
            txAutor = "" + livro.getTxAutor();
            txISBN = "" + livro.getTxISBN();
            intPaginas = Integer.toString(livro.getIntPaginas());
            
        }

        //devolvendo pelo request
        request.setAttribute("lista", dao.lista("Livro"));
        request.setAttribute("operacao", operacao);
        request.setAttribute("errosJava", errosJava);
        request.setAttribute("acao", acao);
        request.setAttribute("idLivro", idLivro);
        request.setAttribute("txTitulo", txTitulo);
        request.setAttribute("txAutor", txAutor);
        request.setAttribute("txISBN", txISBN);
        request.setAttribute("intPaginas", intPaginas);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }
}
