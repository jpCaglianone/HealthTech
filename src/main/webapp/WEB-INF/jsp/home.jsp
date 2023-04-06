<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HealthTech - Tecnologia à serviço da saúde</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="styles.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
        .card{
            min-height: 550px;
            margin-bottom: 50px;
            padding: 10px;
            box-shadow: 5px 5px 8px -2px black;
            transition: all 0.5s;
        }
        .card:hover{
            cursor: pointer;
            background-color: #effbef;
            transition: all 0.2s;
            transform: scale(1.05);
        }
        .card-img-top{
            height: 60%;
        }
    </style>
</head>
<body>
    <c:if test="${not empty user}">
        <div class="alert alert-success" id="mensagem">
            Usuário ${user.getNome()} logado com sucesso!
        </div>
        <style>
            #mensagem {
                display: flex;
                justify-content: center;
            }
        </style>
        <script defer>
            setTimeout(function() {
                $("#mensagem").fadeOut(5000);
            }, 2500);
        </script>
    </c:if>

<c:import url="menu.jsp" />
<div class="container">
    <h1 class="text-center my-5">Tecnologia Hospitalar</h1>
    <p>A tecnologia vem desempenhando um papel cada vez mais importante na medicina. Os avanços na tecnologia hospitalar têm ajudado os profissionais de saúde a melhorar a qualidade do atendimento aos pacientes e a obter diagnósticos mais precisos e rápidos.</p>
    <p>Um dos exemplos mais comuns de tecnologia hospitalar é o equipamento médico. A seguir, confira algumas imagens de equipamentos hospitalares que ajudam os profissionais de saúde a salvar vidas.</p>
    <div class="row my-5">
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://www.tecnodesign.ind.br/imagens/informacoes/aparelho-raio-x-01.jpg" alt="Máquina de raios-x" title="Máquina de raios-x">
                <div class="card-body">
                    <h5 class="card-title">Máquina de Raios-X</h5>
                    <p class="card-text">A máquina de raios-x é um equipamento hospitalar utilizado para diagnosticar diversas condições médicas, como fraturas ósseas e problemas pulmonares.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://www.marcamedica.com.br/media/catalog/product/cache/1/image/380x380/9df78eab33525d08d6e5fb8d27136e95/v/e/ventilador.jpg" alt="Ventilador pulmonar" title="Ventilador pulmonar">
                <div class="card-body">
                    <h5 class="card-title">Ventilador Mecânico</h5>
                    <p class="card-text">O ventilador mecânico é um equipamento hospitalar utilizado para auxiliar a respiração de pacientes com problemas respiratórios graves, como pneumonia e insuficiência respiratória.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://images.tcdn.com.br/img/img_prod/746795/monitor_de_sinais_vitais_bm3_xpro_bionet_3593_1_7bef350670007e4db6bfb8781cb1f1a7.jpg" alt="Monitor de sinais vitais" title="monitor de sinais vitais">
                <div class="card-body">
                    <h5 class="card-title">Monitor de Sinais Vitais</h5>
                    <p class="card-text">O monitor de sinais vitais é um equipamento hospitalar utilizado para monitorar as funções vitais do paciente, como a frequência cardíaca, a pressão arterial e a saturação de oxigênio no sangue.</p>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card">
            <img class="card-img-top" src="https://www.medcleanprodutohospitalar.com.br/media/catalog/product/cache/1/image/800x/9df78eab33525d08d6e5fb8d27136e95/2/_/2_cabo-de-ecg-paciente-5-vias_11.jpg" alt="cabo de ecg" title="cabo de ecg">
            <div class="card-body">
                <h5 class="card-title">Cabo de ECG </h5>
                <p class="card-text">O cabo ECG é um dispositivo médico que é usado para conectar um eletrocardiograma (ECG) ao corpo do paciente.</p>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card">
            <img class="card-img-top" src="https://www.marcamedica.com.br/media/catalog/product/cache/1/image/380x380/9df78eab33525d08d6e5fb8d27136e95/f/o/folder-cardiomax-2_copy_1.jpg" alt="desfibrilador" title="desfibrilador">
            <div class="card-body">
                <h5 class="card-title">Desfibrilador</h5>
                <p class="card-text">Um desfibrilador é um dispositivo médico usado para reverter certos tipos de arritmias cardíacas, que são anomalias no ritmo cardíaco que podem ser fatais se não forem tratadas rapidamente. </p>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="card">
            <img class="card-img-top" src="https://fibracirurgica.vtexassets.com/arquivos/ids/195484/Aparelho-de-Pressao-Premium-Adulto-Nylon-Velcro-3245.jpg?v=637153859969100000" alt="aparelho de pressão" title="aparelho de pressão">
            <div class="card-body">
                <h5 class="card-title">Aparelho de pressão</h5>
                <p class="card-text">O aparelho de pressão, também conhecido como esfigmomanômetro, é um dispositivo médico usado para medir a pressão arterial de uma pessoa.  Ele é composto por uma braçadeira inflável, um manômetro (dispositivo de leitura) e um dispositivo de inflação.</p>
            </div>
        </div>
    </div>
</div>
</div>

<c:import url="footer.jsp" />
<!-- Importando os arquivos JS do Bootstrap -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>
</body>
</html>