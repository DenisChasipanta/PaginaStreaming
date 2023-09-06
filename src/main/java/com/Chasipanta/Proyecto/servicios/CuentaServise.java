package com.Chasipanta.Proyecto.servicios;

import com.Chasipanta.Proyecto.entidades.Cuenta;
import com.Chasipanta.Proyecto.repositorios.CuentaRepositorio;
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
public class CuentaServise implements UserDetailsService {
    @Autowired
    CuentaRepositorio cuentaRepositorio;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cuenta cuenta= cuentaRepositorio.findByUsername(username);
        List<GrantedAuthority> roles= new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDetails = new User(cuenta.getUsername(),cuenta.getPassword(),roles);
        return userDetails;
    }
}
