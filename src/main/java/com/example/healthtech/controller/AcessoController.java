package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class AcessoController {
    private static Usuario user;
    private String alerta;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user",user);
        if (!usuarioService.existeUsuario()){
            model.addAttribute("mensagem", "Não existe nenhum usuário cadastrado!");
        }
        else{
            model.addAttribute("mensagem", null);
        }

        model.addAttribute("alerta",alerta);

        return"acesso/login";
    }


    @PostMapping("login/inserir")
    public String UsuarioLogin(Model model, @RequestParam  String email, @RequestParam String senha){

        alerta = null;
        Usuario user = new Usuario(email,senha);
        user = usuarioService.validacao(user);
        Usuario u = usuarioService.listaUsuariosPorId(user.getId());

        if(user != null && !u.isBloqueado()){
            model.addAttribute("mensagem","Usuário " + user.getNome() + " logado com sucesso!");
            model.addAttribute("user", user);
            return "redirect:/";
        }else{
            alerta = "Email ou senha inválidos!";
            return "redirect:/login";
        }
    }

    @GetMapping("/signin")
    public String signinPage(){
        return"/acesso/signin";
    }


    @PostMapping("signin/inclusao")
    public String UsuarioInclusao(Model model, @RequestParam String nomeUsuario, @RequestParam String emailUsuario, @RequestParam String senhaUsuario, @RequestParam int nivelUsuario){

        Usuario user = new Usuario( emailUsuario, nomeUsuario, senhaUsuario, nivelUsuario,false);

         if (!usuarioService.incluirUsuario(user)){
            model.addAttribute("mensagem",  "Não foi possivel cadastrar o usuário!");
            return "redirect:/acesso/signin";
        }
        model.addAttribute("mensagem", "Usuário incluido com sucesso!");
        return "redirect:/";

    }
        @GetMapping("controleUsuarios")
        public String listaUsuarios(Model model,@SessionAttribute("user")Usuario usuario){
            if (usuario!=null) {
                model.addAttribute("usuarios", usuarioService.listaUsuarios());

                return "/acesso/controleUsuarios";
            }
            return "redirect:/";
        }



        @GetMapping("/controleUsuarios/{indice}/status")
        public String excluirUsuario(@PathVariable Integer indice){

            Usuario u = usuarioService.listaUsuariosPorId(indice);

            usuarioService.editaUsuario(u.getId(), !u.isBloqueado());
            return "redirect:/controleUsuarios";
        }


    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        setUsuarioNull();
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
