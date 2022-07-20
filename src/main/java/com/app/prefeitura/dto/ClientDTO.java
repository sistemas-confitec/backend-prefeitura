package com.app.prefeitura.dto;

import java.io.Serializable;
import java.time.Instant;

import com.app.prefeitura.entities.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public ClientDTO() {

	}

	public ClientDTO(Long id, String name, String cpf, Double income, Instant birtDate, Integer children) {
		this.id = id;
		this.name = name;
	}

	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
