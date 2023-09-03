package com.Chasipanta.Proyecto.repositorios;

import com.Chasipanta.Proyecto.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepositorio extends JpaRepository<Cuenta,Integer> {
}
