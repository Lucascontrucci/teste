package com.salesunity.appsu.core.repositories;

import com.salesunity.appsu.core.entities.ItemCotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCotacaoRepository extends JpaRepository<ItemCotacao, Long> {
}
