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

<c:if test="${not empty mensagem}">
    <div class="alert alert-danger">
        <strong>Atenção!</strong> ${mensagem}!
    </div>
</c:if>
    <div class="container">
        <h1>Cadastro de acessorios</h1>
        <form action="cadastroEquipamento/incluir" method="post">

        <div id="produto">
            <div class="form-group">
                <label for="nomeProduto">Nome:</label>
                <input type="text" class="form-control" id="nomeProduto" name="nomeProduto" placeholder="Insira o nome do produto" required>
            </div>


            <div class="form-group">
                <label for="quantidadeProduto">Quantidade:</label>
                <input type="number" class="form-control" id="quantidadeProduto" name="quantidadeProduto" placeholder="Insira a quantidade" required>
            </div>


            <div class="form-group">
                <label for="valorProduto">Preço:</label>
                <input type="number" class="form-control" id="valorProduto" name="valorProduto" placeholder="Insira preço" onchange="validaNumero()" required>
            </div>


            <div class="form-group">
                <label for="marcaProduto">Marca:</label>
                <input type="text" class="form-control" id="marcaProduto" name="marcaProduto" placeholder="Insira a marca" required>
            </div>
        </div>

            <div class="form-group">
                <label for="anoFabricacao">Ano de fabricação:</label>
                <input type="number" class="form-control" id="anoFabricacao" name="anoFabricacao" placeholder="Insira o ano de fabricação do equipamento" required>
            </div>

            <div class="form-group">
                <label for="numeroSerie">Número de série:</label>
                <input type="text" class="form-control" id="numeroSerie" name="numeroSerie" placeholder="Insira o número de série do equipamento" required>
            </div>

            <div id="tensao">
                <span>Tensão do equipamento</span>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao" value="0" id="flexRadioDefault1" >
                    <label class="form-check-label" for="flexRadioDefault1">
                        127V
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao" id="flexRadioDefault2" value="1" checked >
                    <label class="form-check-label" for="flexRadioDefault2">
                        220V(bifásico)
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao"  value="2"  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        220V(trifásico)
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao"  value="3"  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        12V
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao" value="4"  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        24V
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tensao"  value="5"  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        48V
                    </label>
                </div>

                <div id="corrente">
                    <span>Corrente do equipamento: </span>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="0" checked >
                        <label class="form-check-label" for="flexRadioDefault1">
                            250mA
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="1" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            500mA
                        </label>
                    </div>

                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="2" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            1A
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="3" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            2A
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="3" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            5A
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="corrente" value="3" >
                        <label class="form-check-label" for="flexRadioDefault2">
                            10A
                        </label>
                    </div>
                </div>
                </div>

            <div id="estado">
                <span>Estado do equipamento: </span>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="estado" value="usado" checked >
                    <label class="form-check-label" for="flexRadioDefault1">
                        Usado
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="estado" value="novo" checked >
                    <label class="form-check-label" for="flexRadioDefault1">
                        Novo
                    </label>
                </div>
            </div>


            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <button class="btn btn-danger" onclick="limparCampos()">Limpar</button>
        </form>
    </div>
<c:if test="${not empty mensagem}">
    <script>
        alert(mensagem);
    </script>
</c:if>
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