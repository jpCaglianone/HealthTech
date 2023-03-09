









a fazer:
    - quanto o sistema está logado, a mensagem de logado sempre aparece ao voltar no inicio, é necessario colocar um controlador true/false para que a mensagem apareça apenas uma vez
    - melhorar a tabela de lista
    - colocar id nas tabelas com map
    - terminar o repository e service acessorio
    - modificar a cor das mensagens
    - colocar o alert da volta da home apenas uma vez
    - colocar alert no cadastro




<c:choose>
  <c:when test="${temPermissao == true}">
    <p>A variável é verdadeira</p>
  </c:when>
  <c:otherwise>
    <p>A variável é falsa</p>
  </c:otherwise>
</c:choose>