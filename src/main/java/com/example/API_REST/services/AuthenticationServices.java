package com.example.API_REST.services;

import com.example.API_REST.models.UsuarioModel;
import com.example.API_REST.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServices implements UserDetailsService {

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel user=repositorio.findByUser(username).get(0);
        List<GrantedAuthority> roles= new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDet=new User(user.getUser(), user.getPass(),roles);
        return userDet;
    }
}
