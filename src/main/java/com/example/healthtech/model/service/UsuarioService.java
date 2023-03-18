package com.example.healthtech.model.service;

import com.example.healthtech.model.domain.Requisitante;
import com.example.healthtech.model.domain.Usuario;
import com.example.healthtech.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean incluirUsuario(Usuario usuario){

        try {
            usuarioRepository.save(usuario);
            System.out.println("Usuario incluido com sucesso!");
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public void excluirUsuario (Integer id){
        usuarioRepository.deleteById(id);
    }
    public Iterable<Usuario> listaUsuarios(){

        return  usuarioRepository.findAll();

    }

//    public  Usuario validacao (String email, String senha){
//
//        //return usuarioRepository.validacao(email,senha);
//        return usuarioRepository;
//    }

    public Usuario validacao (Usuario usuario){

        return usuarioRepository.validacao(usuario.getEmail(), usuario.getSenha());
    }

    public boolean existeUsuario(){
        if (this.listaUsuarios() == null){
            return false;
        }
        return true;
    }

}
