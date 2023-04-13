package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Usuario;
import feign.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
    @Query("from Usuario where emailUsuario = :email and senhaUsuario = :senha") //o user é o alias
    Usuario validacao(String email, String senha);

    @Query("from Usuario u where u.id = :id")
    Usuario listaUsuariosPorId(Integer id);

    @Modifying
    @Query("UPDATE Usuario u SET u.bloqueado = :status WHERE u.id = :id")
    void editarUsuario(Integer id, Boolean status);

}
