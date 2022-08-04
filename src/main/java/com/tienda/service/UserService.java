package com.tienda.service;

import com.tienda.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    public IPersonaService personaService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Persona persona = this.personaService.findByNombre(username);
        Userprincipal userPrincipal = new Userprincipal(persona);
        return userPrincipal;
    }
}
