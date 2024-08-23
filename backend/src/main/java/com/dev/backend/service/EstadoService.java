package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dev.backend.entity.estado;
import com.dev.backend.repository.EstadoRepository;

@Service
public class EstadoService {
    
    
    @Autowired
    private EstadoRepository estadoRepository;

    public List<estado> buscarTdos(){
        return estadoRepository.findAll();
    }
     
    public estado inserir(estado Estado){
        Estado.setDataCriacao(new Date());
        estado estadoNovo = estadoRepository.saveAndFlush(Estado);
        return estadoNovo;

       }

    public estado alterar( estado Estado){
        Estado.setDataAtualizacao(new Date());
     return estadoRepository.saveAndFlush(Estado);
    }

    public void excluir( Long Id){
    estado Estado = estadoRepository.findById(Id).get();
    estadoRepository.delete(Estado);
    }

    
}
