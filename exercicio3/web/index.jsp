
<%@page import="br.iesb.modelo.Estagiario"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Estagiario> lista = (ArrayList<Estagiario>) request.getAttribute("lista"); 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <title>Lista de Estagiarios</title>
    </head>
    <body>
        <p align="left">
            <a href="./verEstagiario?operacao=novo">Novo</a>
        </p>
        <hr>
        <table  class="form-control"  border="1">
            <%
            if(!lista.isEmpty()){ %>
                <tr>
                    <td>Código</td> 
                    <td>Nome</td>
                    <td>Curso</td>
                    <td>Valor da Bolsa</td>
                    <td>Valor Ticket Refeição</td>
                    <td>Carga Horaria</td>
                    <td>Anos de Experiência</td>
                    <td>Duração do Estágio</td>
                </tr>
            <%
                for(Estagiario p : lista){%>
                    <tr>
                        <td><%=p.getIdEstagiario()%></td>
                        <td><%=p.getTxNome()%></td>
                        <td><%=p.getTxCurso()%></td>
                        <td><%=p.getNfValorBolsa()%></td>
                        <td><%=p.getNfValorTicketRefeicao()%></td>
                        <td><%=p.getNiCargaHoraria()%></td>
                        <td><%=p.getNiAnosExperiencia()%></td>
                        <td><%=p.getNiDuracaoEstagio()%></td>
                        <td>
                            <a href="./verEstagiario?operacao=alterar&idEstagiario=<%=p.getIdEstagiario()%>">Alterar</a>
                            &nbsp; | &nbsp;
                            <a href="./verEstagiario?operacao=excluir&idEstagiario=<%=p.getIdEstagiario()%>">Excluir</a>
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
