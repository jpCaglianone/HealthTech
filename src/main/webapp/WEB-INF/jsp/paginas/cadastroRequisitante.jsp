<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Home Page with Bootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<c:import url="../menu.jsp" />
    <div class="container">
        <h1>Cadastro de usuário</h1>
        <form action="cadastroRequisitante/incluir" method="post">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" placeholder="Insira o seu nome">
            </div>
            <div class="form-group">
                <label for="tipoRequisitante">Tipo de requisitante:</label>
                <input type="number" class="form-control" id="tipoRequisitante" name="tipoRequisitante" placeholder="Insira o tipo de requisitante">
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="orgao" value="Público" id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                    Público
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="orgao" id="flexRadioDefault2" value="Privado" checked>
                <label class="form-check-label" for="flexRadioDefault2">
                    Privado
                </label>
            </div>

            <button type="submit" class="btn btn-primary">Enviar</button>
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