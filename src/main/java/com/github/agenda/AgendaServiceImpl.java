package com.github.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository repository;

    @Autowired
    public AgendaServiceImpl(AgendaRepository repository) {
        this.repository = repository;
    }

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
