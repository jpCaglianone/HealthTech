package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.TipoInsumoException;
import com.example.healthtech.model.exception.ValorValidoException;
import com.example.healthtech.model.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class InsumoController {

    String mensagem;

    @Autowired
    InsumoService insumoService;

    @GetMapping("/cadastroInsumo")
    public String InsumoListPage(Model model){

        model.addAttribute("mensagem", mensagem);
        return "PaginasInsumo/cadastroInsumo";
    }


        @PostMapping("/cadastroInsumo/incluir")
        public String AcessorioInclusao(Model model, @RequestParam String nomeInsumo, @RequestParam String quantidadeInsumo,
                                        @RequestParam String valorInsumo, @RequestParam String marcaInsumo,
                                        @RequestParam String tipoInsumo, @RequestParam String quantidadeLote,
                                        @RequestParam String durabilidadeInsumo,@SessionAttribute("user") Usuario usuario
                                        ) throws TipoInsumoException, NomeInvalidoException, ValorValidoException {

            mensagem = null;

            Insumo insumo= new Insumo(nomeInsumo, Integer.parseInt(quantidadeInsumo),Float.parseFloat(valorInsumo),marcaInsumo,tipoInsumo,durabilidadeInsumo,Integer.parseInt(quantidadeLote));
            insumo.setUsuario(usuario);
            if (!insumoService.incluirInsumos(insumo)) {
                mensagem = "Não foi possivel incluir o insumo!";
                model.addAttribute("mensagem",  mensagem);
                return "redirect:/cadastroInsumo";
            }
            mensagem = "Insumo incluido com sucesso!";
            model.addAttribute("mensagem", mensagem );


            return "redirect:/cadastroInsumo";

        }



    @GetMapping("/listaInsumo")
    public String ListaAcessoriosPage(Model model, @SessionAttribute("user") Usuario usuario){
        if (usuario.getNivel() == 4) {
            model.addAttribute("listaInsumo", insumoService.listarTodosInsumos());
        }
        else {
            model.addAttribute("listaInsumo", insumoService.listaInsumo(usuario.getId()));
        }
        return "PaginasInsumo/listaInsumo";
    }



    @GetMapping("listaInsumo/{indice}/excluir")
    public String excluirInsumo(@PathVariable Integer indice){
        insumoService.excluirInsumos(indice);
        mensagem = "O equipamento de id " + indice + " foi excluído com sucesso!";
        return "redirect:/listaInsumo";
    }

}
