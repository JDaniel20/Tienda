package com.tienda.service;

import com.tienda.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    public IPersonaService personaService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFountExeption {
        Persona persona = this.personaService.findByNombre(username);
        Userprincipal userPrincipal = new Userprincipal(persona);
        return userPrincipal;
    }
}
