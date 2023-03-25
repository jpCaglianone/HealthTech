package com.example.healthtech;

import com.example.healthtech.model.domain.*;
import com.example.healthtech.model.exception.*;
import com.example.healthtech.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Order(6)
@Component
public class SolicitacaoLoader implements ApplicationRunner {
    @Autowired
    private SolicitacaoService solicitacaoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private RequisicaoService requisicaoService;


    @Autowired
    private UsuarioService usuarioService;
    @Override
    public void run(ApplicationArguments args) {
//        Metodos.arqEnergia();
//
        List<Produto> p1 = new ArrayList<>();

        try {
            Equipamento e1 = new Equipamento("Novo", 2000, "Cardioversor", 4, 7456.54f, "Cardiomax", 4, 2, "3t24/tgwes");
            p1.add(e1);
        }catch (Exception e){
            System.out.println("Erro ao cadastrar o equipamento da solicitação!");
        } catch (NomeInvalidoException e) {
            throw new RuntimeException(e);
        } catch (ValorValidoException e) {
            throw new RuntimeException(e);
        } catch (AnoInvalidoException e) {
            throw new RuntimeException(e);
        } catch (TensaoInvalidaException e) {
            throw new RuntimeException(e);
        }

        produtoService.incluirProduto(p1.get(0));

        Requisitante requisitante = null;
        try {
            requisitante = new Requisitante("leandro",3,"privado","Rua tal",8416);

        } catch (ValorValidoException e) {
            throw new RuntimeException(e);
        } catch (NomeInvalidoException e) {
            throw new RuntimeException(e);
        } catch (TipoInsumoException e) {
            throw new RuntimeException(e);
        }
        requisicaoService.inclusaoRequisitante(requisitante);



        Solicitacao s1 = null;
        try {
            s1 = new Solicitacao(requisitante, p1, "C");
            s1.imprimirSolicitacao();
        } catch (TipoAquisicaoException | SolicitacaoSemProdutoException |
                 SolicitacaoSemRequisitanteException e) {
            System.out.println(e.getMessage());
        }

        Usuario admin0 = new Usuario("admin0@ht.com","admin0", "admin123", 4);
        usuarioService.incluirUsuario(admin0);

        s1.setUsuario(admin0);
        solicitacaoService.incluirSolicitacoes(s1);


    }
}
