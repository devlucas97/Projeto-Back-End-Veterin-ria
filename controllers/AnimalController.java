package com.projeto.veterinaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.veterinaria.dtos.AnimalDTO;
import com.projeto.veterinaria.enums.MensagemEnum;
import com.projeto.veterinaria.services.AnimalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/animal")
@Tag(name = "Animais", description = "Veterinaria API")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping("/listar")
	@Operation(summary = "", description = "Listar todos os dados dos animais.")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @ApiResponse(responseCode = "404", description = "Não encontrado")
	public List<AnimalDTO> listarTodos(){
		return animalService.listarTodos();
	}
	
	@PostMapping("/salvar")
	@Operation(summary = "", description = "Salvar os dados do animal")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @ApiResponse(responseCode = "404", description = "Não encontrado")
	
	public ResponseEntity salvar(@RequestBody AnimalDTO animalDTO) {
		try {
			animalService.salvar(animalDTO);
			return ResponseEntity.ok(MensagemEnum.CADASTRADO.getDescricao());
		}catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/atualizar")
	@Operation(summary = "", description = "Atualizar os dados do animal")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @ApiResponse(responseCode = "404", description = "Não encontrado")
	public ResponseEntity atualizar(@RequestBody AnimalDTO animalDTO) {
		try {
			animalService.salvar(animalDTO);
			return ResponseEntity.ok(MensagemEnum.ATUALIZADO.getDescricao());
		}catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	@PostMapping("/excluir/{id}")
	@Operation(summary = "", description = "Excluir dados do animal")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @ApiResponse(responseCode = "404", description = "Não encontrado")
	public ResponseEntity excluir(@PathVariable Long id) {
		try {
			animalService.excluir(id);
			return ResponseEntity.ok(MensagemEnum.EXCLUIDO.getDescricao());
		}catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@GetMapping("/gerar/relatorio")
	@Operation(summary = "", description = "Realizar download do relatorio em PDF")
	public ResponseEntity gerarRelatorio() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData(
				"attachment", "animal.pdf");
		
		return ResponseEntity.ok().headers(headers)
				.body(animalService.gerarRelatorio());
	}
	
	
	
	
	

}



















