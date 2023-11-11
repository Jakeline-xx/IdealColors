package com.projeto.idealcolors.controller;
import com.projeto.idealcolors.exception.RestNotFoundException;
import com.projeto.idealcolors.repository.CartelaDeCoresRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.projeto.idealcolors.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.projeto.idealcolors.model.Produto;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Slf4j
@RequestMapping("/idealcolors/api/produto")
@RequiredArgsConstructor
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CartelaDeCoresRepository cartelaDeCoresRepository;


    @GetMapping("{id}")
    public EntityModel<Produto> show(@PathVariable long id) {
        log.info("Buscando produto com id " + id);

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o id: " + id));

        return produto.toModel();
    }



    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Produto produto){
        log.info("Cadastrando produto: " + produto);
        produtoRepository.save(produto);

        return ResponseEntity
                .created(produto.toModel().getRequiredLink("self").toUri())
                .body(produto.toModel());
//        log.info("cadastrando produto: " + produto);
//        produtoRepository.save(produto);
//        produto.setCartelaDeCores(cartelaDeCoresRepository.findById(produto.getCartelaDeCores().getIdCartelaDeCores()).get());
//        return ResponseEntity
//                .created(produto.toModel().getRequiredLink("self").toUri())
//                .body(produto.toModel());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Produto> destroy(@PathVariable Long id){
        log.info("apagando produto com id " + id);
        var coloracaoPessoal = produtoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("produto não encontrado"));

        produtoRepository.delete(coloracaoPessoal);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public EntityModel<Produto> update(@PathVariable Long id, @RequestBody @Valid Produto produto){
        log.info("alterando produto com id " + id);
        produtoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("produto não encontrado"));

        produto.setIdProduto(id);
        produtoRepository.save(produto);

        return produto.toModel();
    }
}

