<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//recuperando informações vindas da servlet
String operacao = (String) request.getAttribute("operacao");
String acao = (String) request.getAttribute("acao");

String idEstagiario = (String) request.getAttribute("idEstagiario");
String txNome = (String) request.getAttribute("txNome");
String txCurso = (String) request.getAttribute("txCurso");
String nfValorBolsa = (String) request.getAttribute("nfValorBolsa");
String nfValorTicketRefeicao = (String) request.getAttribute("nfValorTicketRefeicao");
String niCargaHoraria = (String) request.getAttribute("niCargaHoraria");
String niAnosExperiencia = (String) request.getAttribute("niAnosExperiencia");
String niDuracaoEstagio = (String) request.getAttribute("niDuracaoEstagio");


      

if(operacao == null) { operacao = ""; }
if(idEstagiario == null) { idEstagiario = ""; }
if(txNome == null) { txNome = ""; }
if(txCurso == null) { txCurso = ""; }
if(nfValorBolsa == null) { nfValorBolsa = ""; }
if(nfValorTicketRefeicao == null) { nfValorTicketRefeicao = ""; }
if(niCargaHoraria == null) { niCargaHoraria = ""; }
if(niAnosExperiencia == null) { niAnosExperiencia = ""; }
if(niDuracaoEstagio == null) { niDuracaoEstagio = ""; }
%>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <title>Formulário de Estagiarios</title>
    </head>
    <body>
        <form name="frm1" method="post" action="./verEstagiario">
            <input type="hidden" name="idEstagiario" value="<%=idEstagiario%>"/>
            <input type="hidden" name="operacao" value="<%=operacao%>"/>
            <table border="1">
                <tr>
                    <td>Nome</td>
                    <td>
                        <input class="form-control" type="text" name="txNome" size="20" maxlength="100" value="<%=txNome %>"/>
                    </td>
                </tr>
                <tr>
                    <td>Curso</td>
                    <td>
                        <input class="form-control" type="text" name="txCurso" size="20" maxlength="10" value="<%=txCurso%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Valor da Bolsa</td>
                    <td>
                        <input class="form-control" type="text" name="nfValorBolsa" size="20" maxlength="10" value="<%=nfValorBolsa%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Valor do Ticket Refeição</td>
                    <td>
                        <input class="form-control" type="text" name="nfValorTicketRefeicao" size="20" maxlength="10" value="<%=nfValorTicketRefeicao%>"/>
                    </td>
                </tr>
                
                
                <tr>
                    <td>Carga Horaria</td>
                    <td>
                        <input class="form-control" type="text" name="niCargaHoraria" size="20" maxlength="10" value="<%=niCargaHoraria%>"/>
                    </td>
                </tr>
                
                
                <tr>
                    <td>Anos de Experiência</td>
                    <td>
                        <input class="form-control" type="text" name="niAnosExperiencia" size="20" maxlength="10" value="<%=niAnosExperiencia%>"/>
                    </td>
                </tr>
                
                <tr>
                    <td>Duração do Estágio</td>
                    <td>
                        <input class="form-control" type="text" name="niDuracaoEstagio" size="20" maxlength="10" value="<%=niDuracaoEstagio%>"/>
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
