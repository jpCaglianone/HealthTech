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
        <th>Nome</th>
        <th>Tipo de instituição</th>
        <th>Tipo de orgao</th>
        <th>Endereço</th>
        <th>Registro</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="requisitante" items="${listaRequisitantes}">
        <tr>
            <td>${requisitante.getNomeRequisitante()}</td>
            <td>${requisitante.dominioRequisitante()}</td>
            <td>${requisitante.descricaoOrgao()}</td>
            <td>${requisitante.getEnderecoRequisitante()}</td>
            <td>${requisitante.getRegistroRequisitante()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

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