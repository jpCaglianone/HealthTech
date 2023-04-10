<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        Cadastro de Requisitante - HealthTech
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
            label{margin-left: 40px;}
    </style>
</head>
<body>
<c:import url="../menu.jsp" />


<div class="container">

    <form action="cadastroSolicitacao/incluir" method="post">
        <h3>Cadastro de Pedidos</h3>

        <div class="form-group">

            <c:if test="${not empty listaProdutos}">
                <label>Produtos:</label>
                <c:forEach var="produtos" items="${listaProdutos}">
                    <div class="form-check">
                        <label class="form-check-label">  ${produtos.getNomeProduto()} - ${produtos.getMarca()} - ( ${produtos.getValor()} )
                            <input type="checkbox" name="produtos" value="${produtos.getId()}"  class="form-check-input">
                        </label>
                    </div>
                </c:forEach>
            </c:if>

            <c:if test="${not empty listaRequisitantes}">
                <label>Requisitantes:</label>
                <select name="requisitantes" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                    <c:forEach var="requisitantes" items="${listaRequisitantes}">
                        <option value="${requisitantes.getId()}">${requisitantes.getNomeRequisitante()}</option>
                    </c:forEach>
                </select>
            </c:if>

            <c:if test="${empty listaRequisitantes}">
                <c:set var="botao" value="disabled"/>
                <label>Não existem requisitantes cadastrados!</label>
            </c:if>

            <c:if test="${empty listaProdutos}">
                <c:set var="botao" value="disabled"/>
                <label>Não existem produtos cadastrados!</label>
            </c:if>


            <span>Tipo da solicitação:</span>
            <div class="form-check" id="tipoSolicitacao">
                <label class="form-check-label" for="tipoSolicitacao">
                    Compra
                </label>
                <input class="form-check-input" type="radio" name="tipoSolicitacao" value="C" checked>
            </div>
            <div class="form-check">
                <label class="form-check-label" for="tipoSolicitacao">
                    Aluguel
                </label>
                <input class="form-check-input" type="radio" name="tipoSolicitacao"  value="A"  >

            </div>
        </div>

        <button ${botao} class="btn btn-primary" type="submit">Solicitar</button>
    </form>
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