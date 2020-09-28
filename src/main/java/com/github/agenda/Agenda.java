package com.github.agenda;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("agendas")
public class Agenda {

	@Id
	private String id;
	private String nome;

}
