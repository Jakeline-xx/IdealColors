package com.projeto.idealcolors.controller;

import java.util.ArrayList;
import java.util.List;

import com.projeto.idealcolors.exception.RestNotFoundException;
import com.projeto.idealcolors.model.ColoracaoPessoal;
import com.projeto.idealcolors.repository.CartelaDeCoresRepository;
import com.projeto.idealcolors.repository.ColoracaoPessoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/idealcolors/api/coloracaopessoal")
public class ColoracaoPessoalController {
    List<ColoracaoPessoal> coloracoesPessoais = new ArrayList<>();
    @Autowired
    ColoracaoPessoalRepository coloracaoPessoalRepository;
    @Autowired
    CartelaDeCoresRepository cartelaDeCoresRepository;
    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping("{id}")
    public EntityModel<ColoracaoPessoal> show(@PathVariable Long id){
        log.info("buscando coloracao pessoal com id " + id);
        var coloracaoPessoal = coloracaoPessoalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "coloracao pessoal não encontrada"));

        return coloracaoPessoal.toModel();

    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid ColoracaoPessoal coloracaoPessoal){
        log.info("cadastrando coloracao pessoal: " + coloracaoPessoal);
        coloracaoPessoalRepository.save(coloracaoPessoal);
        coloracaoPessoal.setCartelaDeCores(cartelaDeCoresRepository.findById(coloracaoPessoal.getCartelaDeCores().getIdCartelaDeCores()).get());
        return ResponseEntity
                .created(coloracaoPessoal.toModel().getRequiredLink("self").toUri())
                .body(coloracaoPessoal.toModel());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ColoracaoPessoal> destroy(@PathVariable Long id){
        log.info("apagando coloracao pessoal com id " + id);
        var coloracaoPessoal = coloracaoPessoalRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("coloracao pessoal não encontrada"));

        coloracaoPessoalRepository.delete(coloracaoPessoal);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public EntityModel<ColoracaoPessoal> update(@PathVariable Long id, @RequestBody @Valid ColoracaoPessoal coloracaoPessoal){
        log.info("alterando coloracao pessoal com id " + id);
        coloracaoPessoalRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("coloracao pessoal não encontrada"));

        coloracaoPessoal.setIdColoracaoPessoal(id);
        coloracaoPessoalRepository.save(coloracaoPessoal);

        return coloracaoPessoal.toModel();
    }
}
