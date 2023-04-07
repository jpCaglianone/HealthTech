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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
        label{
            margin-left:20px;
        }
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
        <h1>Cadastro de Insumos</h1>
        <form action="cadastroInsumo/incluir" method="post">

            <c:import url="../PaginasProduto/cadastroProduto.jsp" />

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
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>

        </form>
    </div>



<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>
</body>

</body>
</html>