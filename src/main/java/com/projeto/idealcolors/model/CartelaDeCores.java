package com.projeto.idealcolors.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "cartela_de_cores")
public class CartelaDeCores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartela_cores")
    private Long idCartelaDeCores;

    @OneToMany(mappedBy = "cartelaDeCores")
    private List<ColoracaoPessoal> coloracoesPessoais;

    @OneToMany(mappedBy = "cartelaDeCores")
    private List<Produto> produtos;

    @NotEmpty(message = "A lista de cores da cartela é obrigatória")
    @Column(name = "cores_cartela")
    private List<String> coresCartela;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
}




