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
<div class="table-responsive">
    <table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Nome do equipamento</th>
        <th>Quantidade</th>
        <th>Valor inteiro</th>
        <th>Marca</th>
        <th>Estado atual</th>
        <th>Tipo de alimentação</th>
        <th>Número de série</th>
        <th>Ano de fabricação</th>
        <th>Valor atual</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="equipamentos" items="${listaEquipamento}">
        <tr>
            <td>${equipamentos.getNomeProduto()}</td>
            <td>${equipamentos.getQuantidade()}</td>
            <td>${equipamentos.getValor()}</td>
            <td>${equipamentos.getMarca()}</td>
            <td>${equipamentos.getEstado()}</td>
            <td>${equipamentos.getTipoAlimentacao()}</td>
            <td>${equipamentos.getNumeroSerie()}</td>
            <td>${equipamentos.getAnoFabricacao()}</td>
            <td>${equipamentos.getValorEstado()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<c:if test="${not empty mensagem}">
    <p>mensagem</p>
</c:if>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNVQ8ew"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</body>
</html>