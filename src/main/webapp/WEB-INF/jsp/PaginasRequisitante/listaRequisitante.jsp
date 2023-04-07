 <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        Listagem de Requisitantes - HealthTech
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="styles.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<c:import url="../menu.jsp" />
<div class="table-responsive col-10" id="tabela">
    <table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Nome</th>
        <th>Endereco</th>
        <th>Tipo de instituição</th>
        <th>Tipo de orgao</th>
<%--        <th>Endereço</th>--%>
        <th>Registro</th>
        <c:if test="${nivelUsuario==4}" >
             <th>Cadastrado por:</th>
        </c:if>
        <th>Exclusão</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="requisitante" items="${listaRequisitantes}">
        <tr>
            <td>${requisitante.getNomeRequisitante()}</td>
            <td>
                    ${requisitante.getEndereco().logradouro}, ${requisitante.getEndereco().complemento} - ${requisitante.getEndereco().bairro}, ${requisitante.getEndereco().cep} - ${requisitante.getEndereco().localidade}/${requisitante.getEndereco().uf}
            </td>
            <td>${requisitante.dominioRequisitante()}</td>
            <td>${requisitante.descricaoOrgao()}</td>
<%--            <td>${requisitante.getEnderecoRequisitante()}</td>--%>
            <td>${requisitante.getRegistroRequisitante()}</td>
            <c:if test="${nivelUsuario==4}" >
                <th>${requisitante.usuario.getNome()}</th>
            </c:if>
            <td>
                <a href="listaRequisitante/${requisitante.getId()}/excluir">
                    <div class="lixeira"> </div>
                </a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>
</body>

</body>
</html>