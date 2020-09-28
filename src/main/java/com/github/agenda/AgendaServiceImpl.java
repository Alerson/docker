package com.github.agenda;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AgendaServiceImpl implements AgendaService {

	private final AgendaRepository repository;

	@Override
	public List<Agenda> listar() {

		return this.repository.findAll();
	}

	@Override
	public Agenda salvar(Agenda agenda) {

		return this.repository.save(agenda);
	}

	@Override
	public Optional<Agenda> buscarPor(String id) {

		return this.repository.findById(id);
	}

	@Override
	public void excluir(String id) {

		this.buscarPor(id).ifPresent(a -> this.repository.delete(a));
	}

}
