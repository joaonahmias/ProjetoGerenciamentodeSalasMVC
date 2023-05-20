package com.example.projetomvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.projetomvc.model.Sala;
import com.example.projetomvc.repository.SalaRepository;

@Service
public class SalaService{
    SalaRepository repository;

    public SalaService(SalaRepository repository){
        this.repository = repository;
    }

    public void save(Sala sala){
        repository.save(sala);
    }

    public List<Sala> findAll (){
       return repository.findAll();
    }
    public Optional<Sala> findById(Integer id){
        return repository.findById(id);
    }
    public void delete(Sala sala){
        repository.delete(sala);
    }
    
}
