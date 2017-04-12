<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//recuperando informações vindas da servlet
String operacao = (String) request.getAttribute("operacao");
String acao = (String) request.getAttribute("acao");
String idLivro = (String) request.getAttribute("idLivro");
String txTitulo = (String) request.getAttribute("txTitulo");
String txAutor = (String) request.getAttribute("txAutor");
String txPaginas = (String) request.getAttribute("txPaginas");
String txISBN = (String) request.getAttribute("txISBN");

if(operacao == null) { operacao = ""; }
if(idLivro == null) { idLivro = ""; }
if(txTitulo == null) { txTitulo = ""; }
if(txAutor == null) { txAutor = ""; }
if(txPaginas == null) { txPaginas = ""; }
if(txISBN == null) { txISBN = ""; }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de Livros</title>
    </head>
    <body>
        <form name="frm1" method="post" action="./verLivro">
            <input type="hidden" name="idLivro" value="<%=idLivro%>"/>
            <input type="hidden" name="operacao" value="<%=operacao%>"/>
            <table border="1">
                <tr>
                    <td>Livro</td>
                    <td>
                        <input type="text" name="txTitulo" size="20" maxlength="100" value="<%=txTitulo %>"/>
                    </td>
                </tr>
                <tr>
                    <td>Autor</td>
                    <td>
                        <input type="text" name="txAutor" size="20" maxlength="10" value="<%=txAutor%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Paginas</td>
                    <td>
                        <input type="text" name="txPaginas" size="20" maxlength="10" value="<%=txPaginas%>"/>
                    </td>
                </tr>
                <tr>
                    <td>ISBN</td>
                    <td>
                        <input type="text" name="txISBN" size="20" maxlength="10" value="<%=txISBN%>"/>
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
