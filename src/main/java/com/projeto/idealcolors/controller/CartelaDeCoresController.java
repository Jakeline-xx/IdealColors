package com.projeto.idealcolors.controller;

import com.projeto.idealcolors.exception.RestNotFoundException;
import com.projeto.idealcolors.model.ColoracaoPessoal;
import com.projeto.idealcolors.model.Produto;
import com.projeto.idealcolors.repository.*;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.idealcolors.model.CartelaDeCores;
import com.projeto.idealcolors.repository.CartelaDeCoresRepository;
import com.projeto.idealcolors.repository.ColoracaoPessoalRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/idealcolors/api/carteladecores")
public class CartelaDeCoresController {
    @Autowired
    CartelaDeCoresRepository cartelaDeCoresRepository;
    @Autowired
    ColoracaoPessoalRepository coloracaoPessoalRepository;
    @Autowired
    ProdutoRepository produtoRepository;


//    @GetMapping("{id}")
//    public EntityModel<CartelaDeCores> show(@PathVariable Long id){
//        log.info("buscando cartela de cores com id " + id);
//        var cartelaDeCores = cartelaDeCoresRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "cartela de cores não encontrada"));
//
//        return cartelaDeCores.toModel();
//
//    }
//
//    @PostMapping
//    public ResponseEntity<Object> create(@RequestBody @Valid CartelaDeCores cartelaDeCores){
//        log.info("cadastrando cartela de cores: " + cartelaDeCores);
//        cartelaDeCoresRepository.save(cartelaDeCores);
//
//        return ResponseEntity
//                .created(cartelaDeCores.toModel().getRequiredLink("self").toUri())
//                .body(cartelaDeCores.toModel());
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<CartelaDeCores> destroy(@PathVariable Long id){
//        log.info("apagando cartela de cores com id " + id);
//        var cartelaDeCores = cartelaDeCoresRepository.findById(id)
//                .orElseThrow(() -> new RestNotFoundException("cartela de cores não encontrada"));
//
//        cartelaDeCoresRepository.delete(cartelaDeCores);
//
//        return ResponseEntity.noContent().build();
//
//    }
//
//    @PutMapping("{id}")
//    public EntityModel<CartelaDeCores> update(@PathVariable Long id, @RequestBody @Valid CartelaDeCores cartelaDeCores){
//        log.info("alterando cartela de cores com id " + id);
//        cartelaDeCoresRepository.findById(id)
//                .orElseThrow(() -> new RestNotFoundException("cartela de cores não encontrada"));
//
//        cartelaDeCores.setIdCartelaDeCores(id);
//        cartelaDeCoresRepository.save(cartelaDeCores);
//
//        return cartelaDeCores.toModel();
//    }
}
