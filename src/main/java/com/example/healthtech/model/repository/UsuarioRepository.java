package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Usuario;

import java.util.*;

public class UsuarioRepository {
    private static Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
    private static Integer chavePrimaria = 1;

    public static boolean incluirUsuario (Usuario usuario) {
        try{
            usuarios.put(chavePrimaria, usuario);
            chavePrimaria ++;
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static void excluirUsuario (Integer id){
        usuarios.remove(id);
    }

    public static Collection<Usuario> listaUsuarios(){
        return usuarios.values();
    }

    public static void setUsuarios(Map<Integer, Usuario> usuarios) {
        UsuarioRepository.usuarios = usuarios;
    }

    public static Map<Integer, Usuario> getUsuarios() {
        return usuarios;
    }

    public static boolean existeUsuario() {
        if (usuarios.size()==0){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean validacao (String email,String senha){
        return true;
    }

    public static Collection<Usuario> obterLista(){

        return usuarios.values();
    }

}
