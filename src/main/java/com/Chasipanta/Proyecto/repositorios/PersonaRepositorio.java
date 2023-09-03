package com.Chasipanta.Proyecto.repositorios;

import com.Chasipanta.Proyecto.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepositorio extends JpaRepository<Persona,Integer> {
}
