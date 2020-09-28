package com.github.agenda;

import java.util.List;
import java.util.Optional;

public interface AgendaService {

    List<Agenda> listar();
    Agenda salvar(Agenda agenda);
    Optional<Agenda> buscarPor(String id);
    void excluir(String id);
}
