package com.example.projetomvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetomvc.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
    
}
