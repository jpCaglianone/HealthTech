 <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        Listagem de Requisitantes - HealthTech
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="styles.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>


<style>
    label{
        margin-left:20px;
    }
</style>
<c:if test="${not empty mensagem}">
    <div class="alert alert-success" id="mensagem">
            ${mensagem}
    </div>
    <style>

        #mensagem {
            display: flex;
            justify-content: center;
            float:top;
        }
    </style>
    <script defer>
        setTimeout(function() {
            $("#mensagem").fadeOut(5000);
        }, 2500);
    </script>
</c:if>

<c:import url="../menu.jsp"/>

<div class="table-responsive col-10" id="tabela">
    <table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>ID Produto</th>
        <th>Nome acessorio</th>
        <th>Preço</th>
        <th>Marca</th>
        <th>Quantidade</th>
        <th>Tipo de linha</th>
        <th>Equipamento destinado</th>
        <th>Função</th>
        <th>Exclusão</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="acessorios" items="${listaAcessorios}">
        <tr>
            <td>${acessorios.getId()}</td>
            <td>${acessorios.getNomeProduto()}</td>
            <td>${acessorios.getValor()}</td>
            <td>${acessorios.getMarca()}</td>
            <td>${acessorios.getQuantidade()}</td>
            <td>${acessorios.descricaoLinha()}</td>
            <td>${acessorios.getEquipamentoAlvo()}</td>
            <td>${acessorios.funcao()}</td>
            <td>
                <a href="listaAcessorio/${acessorios.getId()}/excluir">
                    <div class="lixeira"> </div>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

</body>

</body>
</html>