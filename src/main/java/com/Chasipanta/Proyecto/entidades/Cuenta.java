package com.Chasipanta.Proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;
    private String username;
    private String password;
    private String rol;
    private LocalDate creacion;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

}
