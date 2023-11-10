package com.projeto.idealcolors.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;

import com.projeto.idealcolors.controller.ColoracaoPessoalController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "coloracao_pessoal")
public class ColoracaoPessoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coloracao_pessoal")
    private Long idColoracaoPessoal;

    @NotEmpty(message = "O tom de pele é obrigatório")
    @Column(name = "tom_de_pele")
    private String tomDePele;

    @NotEmpty(message = "O subtom de pele é obrigatório")
    @Column(name = "subtom_de_pele")
    private String subtomDePele;

    @NotEmpty(message = "A cor dos olhos é obrigatória")
    @Column(name = "cor_dos_olhos")
    private String corDosOlhos;

    @NotEmpty(message = "A cor do cabelo é obrigatória")
    @Column(name = "cor_do_cabelo")
    private String corDoCabelo;

    @ManyToOne
    @JoinColumn(name = "id_cartela_cores")
    private CartelaDeCores cartelaDeCores;

    public EntityModel<ColoracaoPessoal> toModel() {
        return EntityModel.of(
                this
//                linkTo(methodOn(ColoracaoPessoalController.class).show(idColoracaoPessoal)).withSelfRel(),
//                linkTo(methodOn(ColoracaoPessoalController.class).destroy(idColoracaoPessoal)).withRel("delete")
        );
    }
}
