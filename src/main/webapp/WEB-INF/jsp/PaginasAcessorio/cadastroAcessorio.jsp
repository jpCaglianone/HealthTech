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
        <h1>Cadastro de acessorios</h1>
        <form action="cadastroAcessorio/incluir" method="post">

            <c:import url="../PaginasProduto/cadastroProduto.jsp" />

            <div class="form-group">
                <label for="funcao">Função do acessorio:</label>
                <input type="text" class="form-control" id="funcao" name="funcao" placeholder="Descreva a função do acessorio" required>
            </div>

            <div class="form-group">
                <label for="equipamentoAlvo">Equipamento destinado:</label>
                <input type="text" class="form-control" id="equipamentoAlvo" name="equipamentoAlvo" placeholder="Insira o equipamento que o acessorio se destina" required>
            </div>

            <div id="acompanhamento">
                <span>Acompanha equipamento?</span>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="acompanhaEquipamento" value="sim" id="flexRadioDefault1" >
                    <label class="form-check-label" for="flexRadioDefault1">
                        Sim
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="acompanhaEquipamento" id="flexRadioDefault2" value="não" checked >
                    <label class="form-check-label" for="flexRadioDefault2">
                        Não
                    </label>
                </div>

                <div id="linha">
                    <span>Linha: </span>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="linhaAcessorio" value="0" checked >
                        <label class="form-check-label" for="flexRadioDefault1">
                            Padrão
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="linhaAcessorio" value="2" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            Econômica
                        </label>
                    </div>

                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="linhaAcessorio" value="1" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            Premium
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="linhaAcessorio" value="3" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            Remanufaturado
                        </label>
                    </div>
                </div>
                </div>


            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <button class="btn btn-danger" onclick="limparCampos()">Limpar</button>
        </form>
    </div>

<script>

</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>
</body>

</body>
</html>