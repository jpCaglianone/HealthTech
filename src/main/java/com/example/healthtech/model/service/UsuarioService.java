package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean incluirUsuario(Usuario usuario){
        return usuarioRepository.incluirUsuario(usuario);
    }
    public void excluirUsuario (Integer id){
        usuarioRepository.excluirUsuario(id);
    }
    public Collection<Usuario> listaUsuarios(){
       return usuarioRepository.listaUsuarios();
    }

    public Usuario validacao (String email, String senha){

        return usuarioRepository.validacao(email,senha);
    }
    public Collection<Usuario> obterLista(){
        return usuarioRepository.obterLista();
    }

    public boolean existeUsuario(){
        return usuarioRepository.existeUsuario();
    }

}
