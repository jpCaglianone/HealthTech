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
    <c:if test="${not empty mensagem}">
        <script>
            alert(mensagem);
        </script>
    </c:if>
</head>
<body>
<c:import url="../menu.jsp" />
    <div class="container">
        <h1>Cadastro de Insumos</h1>
        <form action="cadastroInsumo/incluir" method="post">

            <div id="produto">
                <div class="form-group">
                    <label for="nomeInsumo">Nome:</label>
                    <input type="text" class="form-control" id="nomeInsumo" name="nomeInsumo" placeholder="Insira o nome do insumo" required>
                </div>


                <div class="form-group">
                    <label for="quantidadeInsumo">Quantidade:</label>
                    <input type="number" class="form-control" id="quantidadeInsumo" name="quantidadeInsumo" placeholder="Insira a quantidade" required>
                </div>


                <div class="form-group">
                    <label for="valorInsumo">Preço:</label>
                    <input type="number" class="form-control" id="valorInsumo" name="valorInsumo" placeholder="Insira preço"  required>
                </div>


                <div class="form-group">
                    <label for="marcaInsumo">Marca:</label>
                    <input type="text" class="form-control" id="marcaInsumo" name="marcaInsumo" placeholder="Insira a marca" required>
                </div>

            <div id="tipoInsumo">
                <span>Tipo do insumo</span>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tipoInsumo" value="dependente" >
                    <label class="form-check-label" for="tipoInsumo">
                        Dependente de dispositivo
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tipoInsumo"  value="independente" checked >
                    <label class="form-check-label" for="tipoInsumo">
                        Independente de dispositivo
                    </label>
                </div>
            </div>

                <div id="durabilidadeInsumo">
                    <span>Durabilidade do insumo</span>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="durabilidadeInsumo" value="Descartável" >
                        <label class="form-check-label" for="durabilidadeInsumo">
                            Descartável
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="durabilidadeInsumo"  value="permanente" checked >
                        <label class="form-check-label" for="durabilidadeInsumo">
                            Permanente
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="quantidadeLote">Quantidade por lote:</label>
                    <input type="number" class="form-control" id="quantidadeLote" name="quantidadeLote" placeholder="Insira a quantidade por lote" required>
                </div>

            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>



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