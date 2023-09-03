package com.Chasipanta.Proyecto.controladores;

import com.Chasipanta.Proyecto.entidades.Cuenta;
import com.Chasipanta.Proyecto.entidades.Persona;
import com.Chasipanta.Proyecto.repositorios.CuentaRepositorio;
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
public class CuentaControlador {

    @Autowired
    CuentaRepositorio cuentaRepositorio;
    @Autowired
    PersonaRepositorio personaRepositorio;

    @GetMapping("/cuentas")
    public String cuenta(Model model){
        List<Cuenta> cuentas=cuentaRepositorio.findAll();
        model.addAttribute("cuentas",cuentas);
        return "cuenta/cuenta";
    }
    @GetMapping("/cuenta/form")
    public String formulario(Model model){
        model.addAttribute("cuenta",new Cuenta());
        List<Persona> personas=personaRepositorio.findAll();
        model.addAttribute("personas", personas);
        return "/cuenta/formulario";
    }
    @PostMapping("/cuenta/form")
    public String crear(Cuenta cuenta){
        cuentaRepositorio.save(cuenta);
        return "redirect:/cuentas";
    }

    @GetMapping("/cuenta/editar/{id}")
    public String editar(@PathVariable Integer id,Model model){
        Optional<Persona> personas = personaRepositorio.findById(id);
        model.addAttribute("personas", personas);
        return "redirect:/cuenta/form";
    }

    //Eliminar
    @GetMapping("/cuenta/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        cuentaRepositorio.deleteById(id);
        return "redirect:/cuentas";
    }
}
