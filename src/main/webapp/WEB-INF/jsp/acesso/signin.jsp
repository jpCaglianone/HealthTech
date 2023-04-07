<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign in - HealthTech</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <style>
        .container{
            background-color: #eef4ee;
            border-radius: 10px;
            padding: 10px;
            margin-top:50px;
            height: 625px;
        }
        label{
            margin-top:15px;
            margin-left: 20px;
        }
        h1{
            text-align: center;
        }
    </style>

</head>

<body>

<c:import url="../menu.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h1>Registro de novo usuário</h1>
            <form action="signin/inclusao" method="post">
                <div class="mb-3">
                    <label for="nome" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nomeUsuario" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">E-mail</label>
                    <input type="email" class="form-control" id="email" name="emailUsuario" required>
                </div>
                <div class="mb-3">
                    <label for="senha" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senhaUsuario" minlength="6" required>
                </div>
                <div class="mb-3">
                        <input class="form-check-input" type="radio" name="nivelUsuario" id="nivel0" value="0" checked>
                        <label class="form-check-label" for="nivel0">Nível 0 - Cliente/Requisitante</label>
                </div>
                <div class="mb-3">
                    <input class="form-check-input" type="radio" name="nivelUsuario" id="nivel1" value="1">
                    <label class="form-check-label" for="nivel0">Nível 1 - Usuário consultor</label>
                </div>
                <div class="mb-3">
                    <input class="form-check-input" type="radio" name="nivelUsuario" id="nivel2" value="2">
                    <label class="form-check-label" for="nivel0">Nível 2 - Cadastrante</label>
                </div>
                <div class="mb-3">
                    <input class="form-check-input" type="radio" name="nivelUsuario" id="nivel3" value="3">
                    <label class="form-check-label" for="nivel0">Nível 3 - Administrador </label>
                </div>
                <div class="mb-3">
                    <input class="form-check-input" type="radio" name="nivelUsuario" id="nivel4" value="4" disabled>
                    <label class="form-check-label" for="nivel0">Nível 4 - Super Administrador</label>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>