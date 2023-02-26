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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css" integrity="sha512-XXXXXXX" crossorigin="anonymous" />
</head>

    <style>
        .form-text {
            position: absolute;
            right: 0;
            bottom: 1.75rem;
            z-index: 2;
            display: block;
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
        .vh-100 {
            height: 100vh;
        }

        .card {
            max-width: 500px;
            width: 100%;
        }

    </style>
</head>

<body>

<c:import url="../menu.jsp" />

<div class="d-flex align-items-center justify-content-center vh-100">
    <div class="card shadow-lg border-0 rounded-lg mt-5">
        <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
        <div class="card-body">
            <form>
                <div class="form-floating mb-3">
                    <i class="fa-solid fa-envelope"></i>
                    <label for="inputEmail">Email address</label>
                    <input class="form-control" id="inputEmail" type="email" placeholder="name@example.com" />
                    <div class="form-text"></div>
                </div>
                <div class="form-floating mb-3">
                    <i class="fa-solid fa-lock"></i>
                    <label for="inputPassword">Password</label>
                    <input class="form-control" id="inputPassword" type="password" placeholder="Password" />
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

</body>
</html>