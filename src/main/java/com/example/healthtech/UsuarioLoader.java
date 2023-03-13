package com.example.healthtech;

import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {
    @Autowired
    private UsuarioService usuarioService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario admin = new Usuario("admin@ht.com","admin", "123admin", 4);
        usuarioService.incluirUsuario(admin);
        System.out.println("Usuário admin inserido com sucesso");

        for(int i = 0; i <= 3; i++){
            Usuario user = new Usuario("usuario_" + i + "@ht.com", "usuario" + i, i + "-abc123", i);
            System.out.println("Usuario usuario" + i + " inserido com sucesso!");
        }
    }
}
