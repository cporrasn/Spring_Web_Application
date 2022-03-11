package com.example.API_REST.controller;

import com.example.API_REST.repository.UsuarioRepository;
import com.example.API_REST.services.UsuarioServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsuarioControllerTest {

    @Mock
    private UsuarioRepository repository;
    @InjectMocks
    private UsuarioServices services;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void obtenerUsuarios() {
        assertNotNull(services.obtenerusuarios());
    }

    @Test
    void obtenerUsuariosByID() {

    }

    @Test
    void obtenerUsuariosByNombre() {
    }

    @Test
    void guardarUsuario() {
    }

    @Test
    void deleteUsuario() {
    }
}