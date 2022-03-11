package com.example.API_REST.repository;

import com.example.API_REST.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    ArrayList<UsuarioModel> findByNombre(String nombre);
    ArrayList<UsuarioModel> findByUser(String username);
}
