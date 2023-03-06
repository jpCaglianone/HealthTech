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
<c:import url="../menu.jsp" />
    <div class="container">
        <h1>Cadastro de acessorios</h1>
        <form action="cadastroAcessorio/incluir" method="post">

        <div id="produto">
            <div class="form-group">
                <label for="nomeAcessorio">Nome:</label>
                <input type="text" class="form-control" id="nomeAcessorio" name="nomeAcessorio" placeholder="Insira o nome do produto">
            </div>


            <div class="form-group">
                <label for="quantidadeAcessorio">Quantidade:</label>
                <input type="number" class="form-control" id="quantidadeAcessorio" name="quantidadeAcessorio" placeholder="Insira a quantidade" >
            </div>


            <div class="form-group">
                <label for="valorAcessorio">Preço:</label>
                <input type="text" class="form-control" id="valorAcessorio" name="valorAcessorio" placeholder="Insira preço" onchange="validaNumero()">
            </div>


            <div class="form-group">
                <label for="marcaAcessorio">Marca:</label>
                <input type="text" class="form-control" id="marcaAcessorio" name="marcaAcessorio" placeholder="Insira a marca">
            </div>
        </div>

            <div class="form-group">
                <label for="equipamentoAlvo">Equipamento destinado:</label>
                <input type="text" class="form-control" id="equipamentoAlvo" name="equipamentoAlvo" placeholder="Insira o equipamento que o acessorio se destina">
            </div>

            <div class="form-group">
                <label for="funcaoAcessorio">Função do acessrio:</label>
                <input type="text" class="form-control" id="funcaoAcessorio" name="funcaoAcessorio" placeholder="Descreva a função do acessorio">
            </div>

            <div id="acompanhamento">
                <span>Acompanha equipamento?</span>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="acompanhaEquipamento" value="sim" id="flexRadioDefault1">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Sim
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="acompanhaEquipamento" id="flexRadioDefault2" value="nao" checked>
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
    /*
    let numeroInserido = [];
       let numero = (document.getElementById("valorAcessorio"));
        numero.addEventListener("keypress", () => {
            alert(numero.value.length)
            let numeroVigente = numero.value[numero.value.length]
            alert(numeroVigente);
            if ((numeroVigente <= 0 || numeroVigente >= 9)  && numeroVigente!="."){
                numero.value.pop();
                alert(numeroVigente)
            }
        })

     */
</script>

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