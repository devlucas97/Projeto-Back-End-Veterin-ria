package com.projeto.veterinaria.enums;

public enum MensagemEnum {
	
	CADASTRADO("Registrado cadastrado com sucesso"),
	ATUALIZADO("Registrado atualizado com sucesso"),
	EXCLUIDO("Registrado excluido com sucesso"),
	NAO_EXISTE_ID_ANIMAL("Id do animal nao existe na base de dados");
	
	private String descricao;
	
	MensagemEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
