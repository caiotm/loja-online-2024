package com.dev.backend.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.estado;
import com.dev.backend.service.EstadoService;

@RestController
@RequestMapping("/api/Estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/")
    public List<estado> buscarTodos(){
        return estadoService.buscarTdos();  

    }

    @PostMapping("/")
    public estado inserir(@RequestBody estado Estado){
        return estadoService.inserir(Estado);
    }

    @PutMapping("/")
    public estado alterar(@RequestBody estado Estado){
        return estadoService.alterar(Estado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long Id){
        estadoService.excluir(Id);
        return ResponseEntity.ok().build();
    }
}
