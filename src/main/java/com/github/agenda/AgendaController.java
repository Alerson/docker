package com.github.agenda;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("agendas")
public class AgendaController {

	private final AgendaService service;

	@Autowired
	public AgendaController(AgendaService service) {
		this.service = service;
	}

	@GetMapping
	public List<Agenda> listar() {

		return this.service.listar();
	}

	@GetMapping("{id}")
	public ResponseEntity<Agenda> buscarPor(@PathVariable("id") String id) {

		Optional<Agenda> agenda = this.service.buscarPor(id);
		return ResponseEntity.ok().body(agenda.get());
	}

	@PostMapping
	public ResponseEntity<Agenda> salvar(@RequestBody Agenda agenda) {

		Agenda nova = this.service.salvar(agenda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nova.getId()).toUri();
		return ResponseEntity.created(uri).body(nova);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") String id) {

		this.service.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
