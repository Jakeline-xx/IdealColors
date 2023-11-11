package com.projeto.idealcolors.model;

import javax.validation.constraints.NotEmpty;

import com.projeto.idealcolors.controller.ProdutoController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;

import java.time.LocalDateTime;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @ManyToOne
    @JoinColumn(name = "id_cartela_cores")
    private CartelaDeCores cartelaDeCores;

    @NotEmpty(message = "A descrição do produto é obrigatória")
    @Column(name = "descricao_produto")
    private String descricaoProduto;

    @NotEmpty(message = "A categoria é obrigatória")
    @Column(name = "categoria")
    private String categoria;

    @NotEmpty(message = "A marca é obrigatória")
    @Column(name = "marca")
    private String marca;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "qtd_disponivel")
    private Long qtdDisponivel;

    public EntityModel<Produto> toModel() {
        return EntityModel.of(this,
                                     linkTo(methodOn(ProdutoController.class).show(this.idProduto)).withSelfRel()
//                linkTo(methodOn(ProdutoController.class).destroy(idProduto)).withRel("delete")
        );
    }
}
