<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Log in - HealthTech</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css" integrity="sha512-XXXXXXX" crossorigin="anonymous" />

    <style>
        #formulario{
            margin-top: 200px;
        }
        .form-text {
            margin-top: 10px;
            right: 0;
            z-index: 2;
            width: 2.5rem;
            height: 2.5rem;
            line-height: 2.5rem;
            text-align: center;
            pointer-events: none;
            color: #6c757d;
        }
        .form-control:focus ~ .form-text,
        .form-control:not(:placeholder-shown) ~ .form-text {
            color: #0d6efd;
        }
        .card {
            max-width: 500px;
            width: 100%;
        }

    </style>
</head>

<body>


<c:import url="../menu.jsp" />

<c:if test="${empty mensagem}">


    <c:if test="${not empty alerta}">
        <div class="alert alert-danger" id="mensagem">
                ${alerta}
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


<div class="d-flex align-items-center justify-content-center" id="formulario">
    <div class="card shadow-lg border-0 rounded-lg mt-5">
        <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
        <div class="card-body">
            <form action="login/inserir" method="post">
                <div class="form-floating mb-3">
                    <i class="fa-solid fa-envelope"></i>
                    <label for="inputEmail">Email address</label>
                    <input class="form-control" id="inputEmail" type="email" placeholder="name@example.com" name="email" />
                    <div class="form-text"></div>
                </div>
                <div class="form-floating mb-3">
                    <i class="fa-solid fa-lock"></i>
                    <label for="inputPassword">Password</label>
                    <input class="form-control" id="inputPassword" type="password" placeholder="Password" name="senha"/>
                    <div class="form-text"></div>
                </div>
                <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                    <a class="small" href="#">Forgot Password?</a>
                    <button class="btn btn-primary" type="submit">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
</c:if>
<c:if test="${not empty mensagem}">
    <div class="alert alert-danger" role="alert">
            ${mensagem}
    </div>
</c:if>
</body>
</html>