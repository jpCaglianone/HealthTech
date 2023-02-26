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

<c:import url="menu.jsp" />
<div class="container">
    <h1 class="text-center my-5">Tecnologia Hospitalar</h1>
    <p>A tecnologia vem desempenhando um papel cada vez mais importante na medicina. Os avanços na tecnologia hospitalar têm ajudado os profissionais de saúde a melhorar a qualidade do atendimento aos pacientes e a obter diagnósticos mais precisos e rápidos.</p>
    <p>Um dos exemplos mais comuns de tecnologia hospitalar é o equipamento médico. A seguir, confira algumas imagens de equipamentos hospitalares que ajudam os profissionais de saúde a salvar vidas.</p>
    <div class="row my-5">
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://cdn.pixabay.com/photo/2020/03/31/08/54/medical-4985692_960_720.jpg" alt="Máquina de raios-x">
                <div class="card-body">
                    <h5 class="card-title">Máquina de Raios-X</h5>
                    <p class="card-text">A máquina de raios-x é um equipamento hospitalar utilizado para diagnosticar diversas condições médicas, como fraturas ósseas e problemas pulmonares.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://cdn.pixabay.com/photo/2021/03/26/06/46/ventilator-6121351_960_720.jpg" alt="Ventilador mecânico">
                <div class="card-body">
                    <h5 class="card-title">Ventilador Mecânico</h5>
                    <p class="card-text">O ventilador mecânico é um equipamento hospitalar utilizado para auxiliar a respiração de pacientes com problemas respiratórios graves, como pneumonia e insuficiência respiratória.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://cdn.pixabay.com/photo/2020/06/22/14/24/monitor-5322183_960_720.jpg" alt="Monitor de sinais vitais">
                <div class="card-body">
                    <h5 class="card-title">Monitor de Sinais Vitais</h5>
                    <p class="card-text">O monitor de sinais vitais é um equipamento hospitalar utilizado para monitorar as funções vitais do paciente, como a frequência cardíaca, a pressão arterial e a saturação de oxigênio no sangue.</p>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Importando os arquivos JS do Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>
</body>
</html>