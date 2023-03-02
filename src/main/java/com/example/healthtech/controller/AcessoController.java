package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class AcessoController {
//@autowired\
    //private UsuarioService
    private static Usuario user;



    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user",user);
        if (!UsuarioRepository.existeUsuario()){
            model.addAttribute("user", "Não existe nenhum usuário cadastrado!");
        }
        else{
            model.addAttribute("mensagem", null);
        }
        return"acesso/login";
    }



    @PostMapping("login/inserir")
    public String UsuarioLogin(Model model, @RequestParam  String email, @RequestParam String senha){
        user = UsuarioRepository.validacao(email,senha);
        if(user != null){
            return "redirect:/";
        }else{
            return "redirect:/login";
        }
    }



    @GetMapping("/signin")
    public String signinPage(){
        return"/acesso/signin";
    }





    @PostMapping("signin/inclusao")
    public String UsuarioInclusao(Model model, @RequestParam String nomeUsuario, @RequestParam String emailUsuario, @RequestParam String senhaUsuario, @RequestParam int nivelUsuario){

        Usuario user = new Usuario( emailUsuario, nomeUsuario, senhaUsuario, nivelUsuario);

         if (!UsuarioRepository.incluirUsuario(user)){
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





    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");

        return "redirect:/";
    }




    public static void setUsuarioNull() {
        user = null;
    }




    public static Usuario getUsuario() {
        return user;
    }
}
