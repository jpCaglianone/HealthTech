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
    <style>
        table{
            width: 95%;
        }
        td{
            padding: 1px 3px;
        }
    </style>
</head>
<body>
<c:import url="../menu.jsp" />
<div class="table-responsive col-10" id="tabela">
    <table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>ID Produto</th>
        <th>Nome do Insumo</th>
        <th>Marca</th>
        <th>Quantidade</th>
        <th>Valor unitário</th>
        <th>Quantidade por lote</th>
        <th>Tipo do insumo</th>
        <th>Durabilidade</th>
        <th>Exclusão</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="insumos" items="${listaInsumo}">
        <tr>
            <td>${insumos.getId()}</td>
            <td>${insumos.getNomeProduto()}</td>
            <td>${insumos.getMarca()}</td>
            <td>${insumos.getQuantidade()}</td>
            <td>${insumos.getValor()}</td>
            <td>${insumos.quantidadeLote()}</td>
            <td>${insumos.tipoInsumo()}</td>
            <td>${insumos.descricaoDescartavel()}</td>
            <td>
                <a href="listaInsumo/${insumos.getId()}/excluir">
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