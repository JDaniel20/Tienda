package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.secure.spi.GrantedPermission;

public class Userprincipal implements UserDetails {

    private Persona persona;

    public Userprincipal(Persona persona) {
        this.persona = persona;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthoritys() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        //Extract list of permissions(name)
        this.persona.getPermissionList().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });

        //Extract list of roles (ROLE_name)
        this.persona.getRoleList().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });
        return authorities;
    }

}
