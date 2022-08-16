package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.secure.spi.GrantedPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Userprincipal implements UserDetails {  //UserDetails contiene metodos . Lo usamos para guardar la informacion del usuario

    private Persona persona;

    public Userprincipal(Persona persona) {
        this.persona = persona;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {  //Se crea una lista que guarda elemrntos de tipo GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();

        //Extract list of permissions(name)
        this.persona.getPermissionList().forEach(p -> {       //Por cada elemneto que hay en la lista crea un nuevo GrantedAuthority
            GrantedAuthority authority = new SimpleGrantedAuthority(p);  //P es cada elemnto que tenemos en la lista 
            authorities.add(authority);                                 //GrantedAuthority es un permiso que usualmente se representa en string y dedice que permisos tiene cada usuario
        });

        //Extract list of roles (ROLE_name)
        this.persona.getRoleList().forEach(r -> {        //Añadimos el ROLE 
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r); //Se pone ROLE_ se tiene que usar el prefijo ROLE_ para identificar se estamos usando un role 
            authorities.add(authority);                                     //Se guarda en la lista de autoridades
        });
        return authorities;
    }
  
    //UserDetails es una interfaz y debemos implementar los metodos 
    //En una interfaz tenemos que metodos se deben implentar pero no como se implementan 
    
    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.persona.getActive() == 1;
    }

}
