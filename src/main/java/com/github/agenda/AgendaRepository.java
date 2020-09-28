package com.github.agenda;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AgendaRepository extends MongoRepository<Agenda, String> {
}
