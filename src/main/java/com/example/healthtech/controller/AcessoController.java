package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AcessoController {

    private static String mensagem;

    @GetMapping("/login")
    public String loginPage(){
        return"acesso/login";
    }
    @GetMapping("/signin")
    public String signinPage(){
        return"acesso/signin";
    }

    @PostMapping("signin/inclusao")
    public String UsuarioInclusao(Model model, @RequestParam String nomeUsuario, @RequestParam String emailUsuario, @RequestParam String senhaUsuario, @RequestParam int nivelUsuario){

        Usuario usuario;
        usuario = new Usuario( emailUsuario, nomeUsuario, senhaUsuario, nivelUsuario);

         if (!UsuarioRepository.incluirUsuario(usuario)){
            model.addAttribute("mensagem",  "Não foi possivel cadastrar o usuário!");
            return "redirect:/signin";
        }
        model.addAttribute("mensagem", "Usuário incluido com sucesso!");
        return "redirect:/";

    }
}
