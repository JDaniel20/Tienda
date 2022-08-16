package com.tienda.repository;

import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {  //Persona es la clase 

    Persona findByNombre(String nombre); //A;adir metodo  //Se devulve una persona porque estamos buscando a alguine en especifico, por eso no devuleve una lista 
}
