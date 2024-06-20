package com.projeto.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.veterinaria.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
