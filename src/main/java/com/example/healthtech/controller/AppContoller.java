package com.example.healthtech.controller;

import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AppContoller {

    @GetMapping("/")
    public String viewHomePage(Model model) {

        Usuario user = AcessoController.getUsuario();
        model.addAttribute("user",user);
        AcessoController.setUsuarioNull();
        return "home";
    }

    @GetMapping("/sobre")
    public  String aboutPage(){
        return"/sobre";
    }
}
