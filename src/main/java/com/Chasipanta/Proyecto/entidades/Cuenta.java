package com.Chasipanta.Proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;
    private String usuario;
    private String password;
    private LocalDate creacion;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
}
