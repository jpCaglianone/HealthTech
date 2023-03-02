<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-0zDbGvJgRLd6iO9C58kPjV/tgjhEjk1vgVb1Ohz81iRmSJmI/dgD+z2m9XoM/hkV94ylu/1I/5n5p5r1Md5B5w==" crossorigin="anonymous" />
    <style>
        nav{
            background-image: linear-gradient(90deg, #d7d7d7, #b5deaf);
            margin-top: 50px;
            font-size: 20px;
            font-weight: bold;
            font-family: "Times New Roman",Cambria,sans-serif;
        }
        #log{
            float:right;
        }
    </style>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light" >

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Principal</a>
            </li>
            <c:if test="${not empty user}">
                <c:if test="${user.getNivel()>1}" >
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Listagens
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                    <a class="dropdown-item" href="listaRequisitante">Requisitantes</a>
                    <a class="dropdown-item" href="#">Acessórios</a>
                    <a class="dropdown-item" href="#">Insumos</a>
                    <a class="dropdown-item" href="#">Equipamentos</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Cadastros
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <a class="dropdown-item" href="/cadastroRequisitante">Requisitantes</a>
                    <a class="dropdown-item" href="#">Acessórios</a>
                    <a class="dropdown-item" href="#">Insumos</a>
                    <a class="dropdown-item" href="#">Equipamentos</a>
                </div>
            </li>
                </c:if>
                <c:if test="${user.getNivel() == 4}">
            <li class="nav-item">
                <a class="nav-link" href="controleUsuarios">Controle de Usuários</a>
            </li>
                </c:if>
                <c:if test="${user.getNivel() == 0}">
                    <li class="nav-item">
                        <a class="nav-link" href="">Solicitacao</a>
                    </li>
                </c:if>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="sobre">Sobre nós</a>
            </li>
        </ul>
    </div>
    <div id="log">

        <c:if test="${not empty user}">
        <a href="logout">
        <button class="btn btn-danger" id="logout" >
            <i class="fa fa-sign-out"></i> Logout, ${user.getNome()}
        </button>
        </a>
        </c:if>

        <c:if test="${empty user}">
        <a href="signin">
            <button class="btn btn-success" id="Sign in">
                <span class="glyphicon glyphicon-user"></span> Sign-up
            </button>
        </a>
        <a href="login">
            <button class="btn btn-success" id="login">
                <span class="glyphicon glyphicon-log-in"></span> Login
            </button>
        </a>
        </c:if>
    </div>
</nav>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        $(".dropdown").mouseenter(function() {
            $(this).addClass("show");
            $(this).find(".dropdown-menu").addClass("show");
        });
        $(".dropdown").mouseleave(function() {
            $(this).removeClass("show");
            $(this).find(".dropdown-menu").removeClass("show");
        });
    });
</script>
</body>
</html>