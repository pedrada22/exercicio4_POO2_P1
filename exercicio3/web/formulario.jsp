<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//recuperando informações vindas da servlet
String operacao = (String) request.getAttribute("operacao");
String acao = (String) request.getAttribute("acao");
String errosJava = (String) request.getAttribute("errosJava");
String idLivro = (String) request.getAttribute("idLivro");
String txTitulo = (String) request.getAttribute("txTitulo");
String txAutor = (String) request.getAttribute("txAutor");
String txISBN = (String) request.getAttribute("txISBN");
String intPaginas = (String) request.getAttribute("intPaginas");


if(operacao == null) { operacao = ""; }
if(idLivro == null) { idLivro = ""; }
if(txTitulo == null) { txTitulo = ""; }
if(txAutor == null) { txAutor = ""; }
if(txISBN == null) { txISBN = ""; }
if(intPaginas == null) { intPaginas = "0"; }

%>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <title>Formulário de Livro</title>
    </head>
    <body>
        <form name="frm1" method="post" action="./verLivro">
            <input type="hidden" name="idLivro" value="<%=idLivro%>"/>
            <input type="hidden" name="operacao" value="<%=operacao%>"/>
            <table border="1">
                <tr>
                    <td>Titulo</td>
                    <td>
                        <input class="form-control" type="text" name="txTitulo" size="20" maxlength="500" value="<%=txTitulo %>"/>
                    </td>
                </tr>
                <tr>
                    <td>Autor</td>
                    <td>
                        <input class="form-control" type="text" name="txAutor" size="20" maxlength="500" value="<%=txAutor%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Código ISBN</td>
                    <td>
                        <input class="form-control" type="text" name="txISBN" size="20" maxlength="10" value="<%=txISBN%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Qnt. páginas</td>
                    <td>
                        <input class="form-control" type="text" name="intPaginas" size="20" maxlength="7" value="<%=intPaginas%>"/>
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <%
                        if("novo".equals(operacao)){%>
                            <input type="submit" name="acao" value="Incluir"/>
                        <%
                        } else if("alterar".equals(operacao)){%>
                            <input type="submit" name="acao" value="Salvar"/>
                        <%
                        } else if("excluir".equals(operacao)){%>
                            <input type="submit" name="acao" value="Excluir"/>
                        <%
                        }%>
                        <input type="submit" name="acao" value="Voltar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
