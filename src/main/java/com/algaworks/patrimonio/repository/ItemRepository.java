package com.algaworks.patrimonio.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.algaworks.patrimonio.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	  
	List<Item> findByDescricaoContaining(String descricao);
}
