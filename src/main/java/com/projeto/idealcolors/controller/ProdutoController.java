package com.projeto.idealcolors.controller;
import com.projeto.idealcolors.exception.RestNotFoundException;
import com.projeto.idealcolors.repository.CartelaDeCoresRepository;
import io.swagger.v3.oas.annotations.Operation;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Cadastrar um novo produto", description = "Este endpoint é usado para cadastrar um novo produto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados do produto"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao cadastrar o produto")
    })
    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody @Valid Produto produto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Erro de validação: " + bindingResult.getAllErrors());
        }

        log.info("Cadastrando produto: " + produto);

        var produtoSalvo = produtoRepository.save(produto);
        if (produtoSalvo == null || produtoSalvo.getIdProduto() == null) {
            return ResponseEntity.status(500).body("Erro ao cadastrar o produto. Por favor, tente novamente.");
        }

        var idCartelaCor = produtoSalvo.getCartelaDeCores().getIdCartelaDeCores();
        var cartelaCor = cartelaDeCoresRepository.findById(idCartelaCor);

        produtoSalvo.setCartelaDeCores(cartelaCor.orElse(null));

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(produtoSalvo.getIdProduto()).toUri())
                .body(produtoSalvo.toModel());
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
    @DeleteMapping("{id}")
    public ResponseEntity<Produto> destroy(@PathVariable Long id){
        log.info("apagando produto com id " + id);
        var coloracaoPessoal = produtoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("produto não encontrado"));

        produtoRepository.delete(coloracaoPessoal);

        return ResponseEntity.noContent().build();

    }
}

