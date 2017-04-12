
<%@page import="br.iesb.livro.Livro"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Livro> lista = (ArrayList<Livro>) request.getAttribute("lista"); 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Livros</title>
    </head>
    <body>
        <p align="left">
            <a href="./verLivro?operacao=novo">Novo</a>
        </p>
        <hr>
        <table border="1">
            <%
            if(!lista.isEmpty()){ %>
                <tr>
                    <td>Código</td>
                    <td>Titulo</td>
                    <td>Autor</td>
                    <td>Paginas</td>
                    <td>ISBN</td>
                </tr>
            <%
                for(Livro p : lista){%>
                    <tr>
                        <td><%=p.getIdLivro()%></td>
                        <td><%=p.getTxTitulo()%></td>
                        <td><%=p.getTxAutor()%></td>
                        <td><%=p.getNiPaginas()%></td>
                        <td><%=p.getTxISBN()%></td>
                        <td>
                            <a href="./verLivro?operacao=alterar&idLivro=<%=p.getIdLivro()%>">Alterar</a>
                            &nbsp; | &nbsp;
                            <a href="./verLivro?operacao=excluir&idLivro=<%=p.getIdLivro()%>">Excluir</a>
                        </td>
                    </tr>
                <%
                }
            }
            else {%>
                <tr>
                    <td>Não há registros</td>
                </tr>
            <%
            }%>
        </table>
    </body>
</html>
