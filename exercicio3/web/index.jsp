
<%@page import="br.iesb.modelo.Livro"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Livro> lista = (ArrayList<Livro>) request.getAttribute("lista"); 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <title>Lista dos Livros</title>
    </head>
    <body>
        <p align="left">
            <a href="./verLivro?operacao=novo">Novo</a>
        </p>
        <hr>
        <table  class="form-control"  border="1">
            <%
            if(!lista.isEmpty()){ %>
                <tr>
                    <td>Código</td> 
                    <td>Titulo</td>
                    <td>Autor</td>
                    <td>ISBN</td>
                    <td>Paginas</td>
                </tr>
            <%
                for(Livro p : lista){%>
                    <tr>
                        <td><%=p.getIdLivro()%></td>
                        <td><%=p.getTxTitulo()%></td>
                        <td><%=p.getTxAutor()%></td>
                        <td><%=p.getTxISBN()%></td>
                        <td><%=p.getIntPaginas()%></td>
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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</html>
