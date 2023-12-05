package com.salesunity.appsu.core.repositories;

import com.salesunity.appsu.core.entities.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
}
