package com.projeto.veterinaria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.veterinaria.dtos.AnimalDTO;
import com.projeto.veterinaria.entities.Animal;
import com.projeto.veterinaria.enums.MensagemEnum;
import com.projeto.veterinaria.reports.AnimalReport;
import com.projeto.veterinaria.repositories.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public void salvar(AnimalDTO animalDTO) throws Exception{
		Animal animal = new Animal();
		animal.setId(animalDTO.getIdAnimal());
		animal.setNome(animalDTO.getNomeAnimal());
		animal.setEspecie(animalDTO.getEspecieAnimal());
		animalRepository.save(animal);
	}
	
    public List<AnimalDTO> listarTodos(){
    	List<Animal> lista = animalRepository.findAll();
    	List<AnimalDTO> listaDTO = new ArrayList<>();
    	for(Animal animal: lista) {
    		AnimalDTO animalDTO = new AnimalDTO();
    		animalDTO.setIdAnimal(animal.getId());
    		animalDTO.setNomeAnimal(animal.getNome());
    		animalDTO.setEspecieAnimal(animal.getEspecie());

    
    		listaDTO.add(animalDTO);
    	}
    	return listaDTO;
    }
    
    public void excluir(Long id)throws Exception {
    	Animal animal = animalRepository.findById(id).get();
    	if(animal != null) {
    		animalRepository.delete(animal);
    	}
    }
	
    public byte[] gerarRelatorio() {
    	return new AnimalReport(listarTodos()).createPDF();
    }
    
}


























