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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
            label{margin-left: 20px;}
    </style>
</head>
<body>

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

<c:import url="../menu.jsp" />
    <div class="container">
        <h1>Cadastro de usuário</h1>

        <form action="/cep" class="orm-inline" method="post">
            <div class="form-group">
                <label for="cepPesquisa">CEP:</label>
                <input type="number" class="form-control" id="cepPesquisa" name="cepPesquisa"  placeholder="Insira o cep" required>
                <button type="submit" class="btn btn-primary">Busca CEP</button>
            </div>
        </form>
        <form action="cadastroRequisitante/incluir" method="post">
            <div class="form-group">
                <label for="nomeRequisitante">Nome:</label>
                <input type="text" class="form-control" id="nomeRequisitante" name="nomeRequisitante" placeholder="Insira o seu nome">
            </div>

            <div class="form-group">
                <label for="registroRequisitante">Registro do requisitante:</label>
                <input type="number" class="form-control" id="registroRequisitante" name="registroRequisitante" placeholder="Insira o Registro do requisitante">
            </div>
            <div id="orgao">
                <fieldset>
                    <legend>Tipo de orgão</legend>
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
                </fieldset>
            </div>

            <div id="entidade">
                <fieldset>
                    <legend>Tipo de entidade</legend>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipoRequisitante" value="1" id="radioEntidade1">
                <label class="form-check-label" for="radioEntidade1">
                    Hospital
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipoRequisitante" id="radioEntidade2" value="2" checked>
                <label class="form-check-label" for="radioEntidade2">
                    Clinica
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipoRequisitante" value="3" id="radioEntidade3">
                <label class="form-check-label" for="radioEntidade3">
                    Empresa/Instituição
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipoRequisitante" id="radioEntidade4" value="4">
                <label class="form-check-label" for="radioEntidade4">
                    Outro
                </label>
            </div>
                </fieldset>
            </div>

        <c:import url="cadastroEndereco.jsp" />

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>
</body>

</body>
</html>