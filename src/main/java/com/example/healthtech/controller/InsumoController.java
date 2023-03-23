package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Insumo;
import com.example.healthtech.model.exception.NomeInvalidoException;
import com.example.healthtech.model.exception.TipoInsumoException;
import com.example.healthtech.model.exception.ValorValidoException;
import com.example.healthtech.model.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
                                        @RequestParam String durabilidadeInsumo) throws TipoInsumoException, NomeInvalidoException, ValorValidoException {

            mensagem = null;

            Insumo insumo= new Insumo(nomeInsumo, Integer.parseInt(quantidadeInsumo),Float.parseFloat(valorInsumo),marcaInsumo,tipoInsumo,durabilidadeInsumo,Integer.parseInt(quantidadeLote));
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
    public String ListaInsumoPage(Model model){

        model.addAttribute("listaInsumo", insumoService.listarInsumos());

        return "PaginasInsumo/listaInsumo";
    }

}
