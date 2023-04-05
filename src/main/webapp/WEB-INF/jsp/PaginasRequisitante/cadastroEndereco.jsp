<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

        <div class="form-group">
            <label for="logradouro">Logradouro:</label>
            <input type="text" class="form-control" id="logradouro" name="logradouro" value="${endereco.getLogradouro()}" placeholder="Insira o logradouro" disabled>
        </div>

    <div class="form-group">
        <label for="complemento">Complemento:</label>
        <input type="text" class="form-control" id="complemento" name="complemento" placeholder="Insira o complemento" >
    </div>

    <div class="form-group">
        <label for="bairro">Bairro:</label>
        <input type="text" class="form-control" id="bairro" name="bairro" value="${endereco.getBairro()}" placeholder="Insira o bairro" disabled>
    </div>

    <div class="form-group">
        <label for="localidade">Localidade:</label>
        <input type="text" class="form-control" id="localidade" name="localidade" value="${endereco.getLocalidade()}" placeholder="Insira a localidade" disabled>
    </div>
    <div class="form-group">
        <label for="uf">UF:</label>
        <input type="text" class="form-control" id="uf" name="uf" value="${endereco.getUf()}" placeholder="Insira a UF" disabled>
    </div>
<div class="form-group">
    <label for="cep">CEP:</label>
    <input type="text" class="form-control" id="cep" name="cep" value="${endereco.getCep()}" placeholder="" disabled>
</div>

