package com.algaworks.patrimonio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.patrimonio.model.Item;
import com.algaworks.patrimonio.model.Pessoa;
import com.algaworks.patrimonio.repository.PessoaRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class PessoaResource {

	@Autowired	
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/api/pessoas")// get all
	public List<Pessoa> listar(){
		return pessoaRepository.findAll();
	}
	
	@PostMapping("/api/pessoa") // metodo http diferente do feito acima porem post
	public Pessoa adicionar(@RequestBody @Valid Pessoa pessoa ){
	    return pessoaRepository.save(pessoa);
	}
	
	@GetMapping("/api/pessoa/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		
		 pessoaRepository.deleteById(id);
		 return ResponseEntity.ok().build();
	   }
	
	@GetMapping("/api/pessoas/{nome}")
	public List<Pessoa> getByName(@PathVariable("nome") String nome) {
		
		 return pessoaRepository.findByNomeContaining(nome);
	}
}
