package com.tienda.service;

import com.tienda.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
public class UserService implements UserDetailsService {  //Retorna el usario y contraseña

    @Autowired
    public IPersonaService personaService;

    @Override                                                                               //Obtenemos los datos de UserPrincipal
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{ //Cargamos un usarui por el USERNAME
        Persona persona = this.personaService.findByNombre(username);                        //Encontramos por el nombre
        Userprincipal userPrincipal = new Userprincipal(persona);                          
        return userPrincipal;
    }
}

//Podemos usar UserService para validar si un usario existe o no y si puede entrar o no.