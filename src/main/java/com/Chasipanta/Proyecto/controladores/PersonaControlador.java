package com.Chasipanta.Proyecto.controladores;

import com.Chasipanta.Proyecto.entidades.Cuenta;
import com.Chasipanta.Proyecto.entidades.Persona;
import com.Chasipanta.Proyecto.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonaControlador {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @GetMapping("/personas")
    public String persona(Model model){
        List<Persona> personas = personaRepositorio.findAll();
        model.addAttribute("personas",personas);
        return "persona/persona";
    }
    @GetMapping("/persona/form")
    public String formulario(Model model){
        model.addAttribute("persona",new Persona());
        return "/persona/formulario";
    }
    @PostMapping("/persona/form")
    public String crearPersona(Persona persona){
        personaRepositorio.save(persona);
        return "redirect:/persona";
    }
    //CRUD-UPDATE-PUT
    @GetMapping("persona/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona> personas = personaRepositorio.findById(id);
        model.addAttribute("personas", personas);
        return "redirect:/persona/form";
    }
    //ELIMINAR
    @GetMapping("persona/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        personaRepositorio.deleteById(id);
        return "redirect:/personas";
    }


}
