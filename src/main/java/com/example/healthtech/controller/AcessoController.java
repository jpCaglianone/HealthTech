package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.repository.RequisitanteRepository;
import com.example.healthtech.model.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AcessoController {


    @GetMapping("/login")
    public String loginPage(Model model){
        if (!UsuarioRepository.existeUsuario()){
            model.addAttribute("mensagem", "Não existe nenhum usuário cadastrado!");
        }
        else{
            model.addAttribute("mensagem", null);
        }
        return"/acesso/login";
    }

    @PostMapping("login/inserir")
    public String UsuarioLogin(@RequestParam  String email, @RequestParam String senha){
        if(UsuarioRepository.validacao(email,senha)){
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/signin")
    public String signinPage(){
        return"/acesso/signin";
    }

    @PostMapping("signin/inclusao")
    public String UsuarioInclusao(Model model, @RequestParam String nomeUsuario, @RequestParam String emailUsuario, @RequestParam String senhaUsuario, @RequestParam int nivelUsuario){

        Usuario usuario;
        usuario = new Usuario( emailUsuario, nomeUsuario, senhaUsuario, nivelUsuario);

         if (!UsuarioRepository.incluirUsuario(usuario)){
            model.addAttribute("mensagem",  "Não foi possivel cadastrar o usuário!");
            return "redirect:/acesso/signin";
        }
        model.addAttribute("mensagem", "Usuário incluido com sucesso!");
        return "redirect:/";

    }
        @GetMapping("controleUsuarios")
        public String listaUsuarios(Model model){
            model.addAttribute("usuarios", UsuarioRepository.obterLista());
            model.addAttribute("mensagem", "mensagem");

            return "/acesso/controleUsuarios";
        }

        @GetMapping("/controleUsuarios/{indice}/excluir")
    public String excluirUsuario(@PathVariable Integer indice){
            UsuarioRepository.excluirUsuario(indice);
            return "redirect:/controleUsuarios";
        }



}
