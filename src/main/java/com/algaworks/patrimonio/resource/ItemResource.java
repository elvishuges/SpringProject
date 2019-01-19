package com.algaworks.patrimonio.resource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.patrimonio.model.Item;
import com.algaworks.patrimonio.repository.ItemRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class ItemResource {
	
	@Autowired	
	private ItemRepository itemRepository;
	
	@GetMapping("/api/itens")
	public List<Item> listar(){
		//return "estou aqui, get safado";
		return itemRepository.findAll();
	}
	
	@PostMapping("/api/item") // metodo http diferente do feito acima
	public Item adicionar( Item item ){
		LocalDate localDate = LocalDate.now();
		item.setDataAquisicao(localDate);				
		return itemRepository.save(item);
	}
	
	@GetMapping("/api/item/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		
		 itemRepository.deleteById(id);
		 return ResponseEntity.ok().build();
	   }
	
	@GetMapping("/api/itens/{descricao}")
	public List<Item> getByName(@PathVariable("descricao") String descricao) {
		
		 return itemRepository.findByDescricaoContaining(descricao);
	}
	}


