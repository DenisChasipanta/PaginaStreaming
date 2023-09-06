package com.Chasipanta.Proyecto.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaPrincipal {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/paginasStreaming")
    public String paginasStreaming(){
        return "paginasStreaming";
    }
    @GetMapping("/estrenos")
    public String estrenos(){
        return "estrenos";
    }
    @GetMapping("/generos")
    public String generos(){
        return "generos";
    }
    @GetMapping("/logout")
    public String salir(){
        return "logout";
    }

    @GetMapping("/registrados")
    public String registrados(){
        return "registrados";
    }
}
